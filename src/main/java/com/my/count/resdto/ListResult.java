package com.my.count.resdto;

import com.my.count.model.HomeDto;
import lombok.Data;

import java.util.List;

@Data
public class ListResult {
    int count;
    List<HomeDto> list;
}
