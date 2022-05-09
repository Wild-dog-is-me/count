package com.my.count.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/04/03/1:49 PM
 * @Description: 要做耿沁园的男人
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaryDto implements Serializable {

  Integer id;

  LocalDateTime writeDate;

  String diaryTitle;

  String diaryContent;

}
