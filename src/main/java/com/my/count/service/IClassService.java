package com.my.count.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.my.count.model.ClassDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/04/01/5:46 PM
 * @Description: 要做耿沁园的男人
 */

public interface IClassService extends IService<ClassDto> {
  /**
   * 查询所有课程
   */
  List<ClassDto> allClass();

  /**
   * 根据周查询课程
   */
  List<ClassDto> getAllClassByWeek(String week);

  /**
   * 修改课程
   */
  boolean updateClass(ClassDto classDto);

  /**
   * 删除课程
   */
  int deleteClass(List<Integer> ids);

  /**
   * 增加课程
   */
  boolean addClass(ClassDto classDto);


  /**
   * 按周查询课程
   */

}
