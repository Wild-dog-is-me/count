package com.my.count.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/04/01/5:38 PM
 * @Description: 要做耿沁园的男人
 */

@Data
public class ClassDto implements Serializable {
  int id;
  @Excel(name = "星期")
  String weekday;
  @Excel(name = "科目")
  String className;
  @Excel(name = "授课教师", width = 18)
  String teacher;
  @Excel(name = "授课教室", width = 20)
  String classRoom;
  @Excel(name = "周数")
  int week;
  @Excel(name = "节次")
  int times;
}
