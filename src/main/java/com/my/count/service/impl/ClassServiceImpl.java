package com.my.count.service.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.count.dao.IClassMapper;
import com.my.count.model.ClassDto;
import com.my.count.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/04/02/3:42 PM
 * @Description: 要做耿沁园的男人
 */

@Service
public class ClassServiceImpl extends ServiceImpl<IClassMapper,ClassDto> implements IClassService {

  @Autowired
  private IClassMapper classMapper;

  @Autowired
  private RedisTemplate redisTemplate;
  /**
   * 查询所有课程
   */
  @Override
  public List<ClassDto> allClass() {
    return classMapper.allClass();
  }

  /**
   * 根据周查询课程
   *
   * @param week
   */
  @Override
  public List<ClassDto> getAllClassByWeek(String week) {
    return classMapper.getAllClassByWeek(week);
  }

  /**
   * 修改课程
   *
   * @param classDto
   */
  @Override
  public boolean updateClass(ClassDto classDto) {
    return classMapper.updateClass(classDto);
  }

  /**
   * 删除课程
   *
   * @param ids
   */
  @Override
  public int deleteClass(List<Integer> ids) {
    return classMapper.deleteClass(ids);
  }

  /**
   * 增加课程
   *
   * @param classDto
   */
  @Override
  public boolean addClass(ClassDto classDto) {
    return classMapper.addClass(classDto);
  }

  /**
   * 通过excel导入课程
   * @param
   */
  public List<ClassDto> importMemberExcel(MultipartFile file) throws Exception {
    ImportParams importParams = new ImportParams();
    importParams.setTitleRows(1);
    importParams.setHeadRows(1);

    List<ClassDto> list = ExcelImportUtil.importExcel(
      file.getInputStream(),
      ClassDto.class, importParams);

    return list;
  }

}
