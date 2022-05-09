package com.my.count.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.my.count.model.ClassDto;
import com.my.count.model.RespBean;
import com.my.count.service.IClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/04/02/3:48 PM
 * @Description: 要做耿沁园的男人
 */

@RestController
@RequestMapping("api/class")
@Api(tags = "课程表")
public class ClassController {

  @Autowired
  private IClassService classService;

//  @RequestMapping(value = "/allClass", method = RequestMethod.POST)
//  @ApiOperation("获取所有课程")
//  public Object allSong(HttpServletRequest request) {
//    return classService.allClass();
//  }

  @RequestMapping(value = "/allClass", method = RequestMethod.POST)
  @ApiOperation("获取所有课程")
  public ResponseEntity<List<ClassDto>> getAllClass() {
    return ResponseEntity.ok(classService.allClass());
  }


  @RequestMapping(value = "getClassByWeek", method = RequestMethod.POST)
  public ResponseEntity<List<ClassDto>> getByWeek(@RequestParam("week") String week) {
    return ResponseEntity.ok(classService.getAllClassByWeek(week));
  }

  @PostMapping("/updateClass")
  @ApiOperation("修改")
  public ResponseEntity<Boolean> update(@RequestBody ClassDto dto) {
    return ResponseEntity.ok(classService.updateClass(dto));
  }

  @PostMapping("/deleteClass")
  @ApiOperation("批量删除")
  public ResponseEntity<Integer> delete(@RequestBody List<Integer> ids) {
    return ResponseEntity.ok(classService.deleteClass(ids));
  }

  @PostMapping("/addClass")
  @ApiOperation("增加课程")
  public ResponseEntity<Boolean> add(@RequestBody ClassDto classDto) {
    return ResponseEntity.ok(classService.addClass(classDto));
  }

  @ApiOperation(value = "导出课表数据")
  @GetMapping(value = "/export", produces = "application/octet-stream")
  public void exportClass(HttpServletResponse response) {
    List<ClassDto> list = classService.allClass();
    ExportParams exportParams = new ExportParams("课程表", "课程表", ExcelType.HSSF);
    Workbook sheets = ExcelExportUtil.exportExcel(exportParams, ClassDto.class, list);
    ServletOutputStream outputStream = null;
    try {
      //以流形式导出
      response.setHeader("content-type", "application/octet-stream");
      //防止中文乱码
      response.setHeader("content-disposition", "attachment;filename=" +
        URLEncoder.encode("class.xls", "UTF-8"));
      outputStream = response.getOutputStream();
      //写出数据
      sheets.write(outputStream);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (null != outputStream) {
        try {
          outputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * 导入excel
   */
  @ApiOperation("课表数据导入")
  @RequestMapping(value = "/importClassExcel", method = RequestMethod.POST)
  public RespBean employeeImport(MultipartFile file) {
    ImportParams importParams = new ImportParams();
    //去掉标题行防止报错
    importParams.setTitleRows(1);
    try {
      List<ClassDto> employees = ExcelImportUtil.importExcel(file.getInputStream(), ClassDto.class, importParams);
      if (classService.saveBatch(employees)) {
        return RespBean.success("导入成功！");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return RespBean.error("导入失败！");
  }
}
