package com.my.count.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.count.model.ClassDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/04/01/7:21 PM
 * @Description: 要做耿沁园的男人
 */

@Mapper
@Repository
public interface IClassMapper extends BaseMapper<ClassDto> {
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
  int deleteClass(@Param("ids")List<Integer> ids);

  /**
   * 增加课程
   */
  boolean addClass(ClassDto classDto);

  /**
   * 通过excel导入课程
   */
  List<ClassDto> addClassByExcel(List<ClassDto> classDtos);

  /**
   * 按周查询课程
   */
}
