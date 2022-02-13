package com.my.count.controller;

import com.my.count.model.HomeDto;
import com.my.count.reqdto.Querydto;
import com.my.count.resdto.ListResult;
import com.my.count.resdto.SumDto;
import com.my.count.resdto.VsDto;
import com.my.count.service.IHomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/home")
@Api(tags = "首页")
public class Home {

    @Autowired
    IHomeService homeService;

    @PostMapping("/list")
    @ApiOperation("列表查询")
    public ResponseEntity<ListResult> list(@RequestBody Querydto querydto){
        return ResponseEntity.ok(homeService.list(querydto));
    }

    @PostMapping("/add")
    @ApiOperation("添加")
    public ResponseEntity<Boolean> add(@RequestBody HomeDto dto){
        return ResponseEntity.ok(homeService.add(dto));
    }

    @PostMapping("/update")
    @ApiOperation("修改")
    public ResponseEntity<Boolean> update(@RequestBody HomeDto dto){
        return ResponseEntity.ok(homeService.update(dto));
    }


    @PostMapping("/delete")
    @ApiOperation("批量删除")
    public ResponseEntity<Integer> delete(@RequestBody List<Integer> ids){
        return ResponseEntity.ok(homeService.delete(ids));
    }

    @GetMapping("/detail")
    @ApiOperation("详情")
    public ResponseEntity<HomeDto> detail(@RequestParam("id") int id){
        return ResponseEntity.ok(homeService.detail(id));
    }

    @PostMapping("/sum")
    @ApiOperation("分类求和")
    public ResponseEntity<List<SumDto>> sum(@RequestBody Querydto querydto){
        return ResponseEntity.ok(homeService.sum(querydto));
    }

    @PostMapping("/vs")
    @ApiOperation("消费对比")
    public ResponseEntity<List<VsDto>> vs(@RequestBody Querydto querydto){
        return ResponseEntity.ok(homeService.vs(querydto));
    }
}
