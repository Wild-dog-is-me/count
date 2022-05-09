package com.my.count.service;

import com.my.count.model.DiaryDto;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ice_water
 * @Date: 2022/04/03/2:26 PM
 * @Description: 要做耿沁园的男人
 */

public interface IDiaryService {


  /**
   * 查询所有日记（显示标题和时间）
   */
  List<DiaryDto> getAllDiary();

  /**
   * 查看文章详情
   */
  DiaryDto getDiary();

  /**
   * 按标题模糊查询
   */
  List<DiaryDto> getDiaryByTitle();

  /**
   * 修改日记内容
   */
  boolean updateDiary();

  /**
   * 删除日记
   */
  int deleteDiary();

  /**
   * 添加日记
   */
  boolean addDiary();

  /**
   *
   */


}
