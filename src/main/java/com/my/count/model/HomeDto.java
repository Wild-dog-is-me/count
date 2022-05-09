package com.my.count.model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class HomeDto implements Serializable {
    int id;
    String label;
    String custom;
    float count;
    String comment;
    String type;
    Date cusDate;
    Boolean used;
    String pic;
}
