package com.my.count.dao;

import com.my.count.model.HomeDto;
import com.my.count.reqdto.Querydto;
import com.my.count.resdto.SumDto;
import com.my.count.resdto.VsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IHomeMapper {

    /**
     * 查询全部账单
     * @param querydto
     * @return
     */
    List<HomeDto> list(Querydto querydto);

    /**
     * 查询指定日期的消费
     * @param querydto
     * @return
     */
    int count(Querydto querydto);

    /**
     * 总消费接口
     * @param querydto
     * @return
     */
    List<SumDto> sum(Querydto querydto);

    /**
     * 消费对比接口
     * @param querydto
     * @return
     */
    List<VsDto> vs(Querydto querydto);

    /**
     *
     * @param querydto
     * @return
     */
//    int num(Querydto querydto);

    /**
     * 添加账单
     * @param dto
     * @return
     */
    boolean add(HomeDto dto);

    /**
     * 更新账单
     * @param dto
     * @return
     */
    boolean update(HomeDto dto);

    /**
     * 删除账单
     * @param ids
     * @return
     */
    int delete(@Param("ids") List<Integer> ids);

    /**
     * 查看账单细节
     * @param id
     * @return
     */
    HomeDto detail(int id);

}
