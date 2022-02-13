package com.my.count.reqdto;

import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;
import java.util.List;

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

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public List<Timestamp> getDate() {
        return date;
    }

    public void setDate(List<Timestamp> date) {
        this.date = date;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
