package com.my.count.reqdto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class Querydto {
    @ApiModelProperty(value = "关键字")
    String keyword;
    @ApiModelProperty(value = "类型")
    String type;

    @ApiModelProperty(value = "是否已经消费")
    boolean used;
    @ApiModelProperty(value = "起止日期")
    List<Timestamp> date;

    @ApiModelProperty(value = "页码（从1开始）")
    int page;
    @ApiModelProperty(value = "每页数量")
    int num;
}
