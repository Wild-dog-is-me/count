package com.my.count.servicempl;

import com.my.count.dao.IHomeMapper;
import com.my.count.model.HomeDto;
import com.my.count.reqdto.Querydto;
import com.my.count.resdto.ListResult;
import com.my.count.resdto.SumDto;
import com.my.count.resdto.VsDto;
import com.my.count.service.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.http.HTTPException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService implements IHomeService {

    @Autowired
    IHomeMapper mapper;

    private String filterType(String type, String keyWorld) {

        String queryString = "";
        List<String> types = new ArrayList<String>() {{
            add("label");
            add("custom");
            add("type");
            add("comment");
        }};
        if (type.equals("all")) {
            for (String tp : types
            ) {
                queryString +=  tp + " like '%" + keyWorld + "%' or ";
            }
            queryString = queryString.substring(0, queryString.length() - 3);
        } else if (types.contains(type)) {
            queryString += type + " like '%" + keyWorld + "%'";
        } else {
            throw new HTTPException(400);
        }

        return queryString;
    }

    @Override
    public ListResult list(Querydto querydto) {
        querydto.setPage((querydto.getPage() - 1) * querydto.getNum());
        querydto.setType(filterType(querydto.getType(), querydto.getKeyword()));
        ListResult result = new ListResult();
        result.setList(mapper.list(querydto));
        result.setCount(mapper.count(querydto));
        return result;
    }

    @Override
    public boolean add(HomeDto dto) {
        return mapper.add(dto);
    }

    @Override
    public boolean update(HomeDto dto) {
        return mapper.update(dto);
    }

    @Override
    public int delete(List<Integer> ids) {
        return mapper.delete(ids);
    }

    @Override
    public HomeDto detail(int id) {
        return mapper.detail(id);
    }

    @Override
    public List<SumDto> sum(Querydto querydto) {
        querydto.setType(filterType(querydto.getType(), querydto.getKeyword()));
        return mapper.sum(querydto);
    }

    @Override
    public List<VsDto> vs(Querydto querydto) {
        querydto.setType(filterType(querydto.getType(), querydto.getKeyword()));
        return mapper.vs(querydto);
    }
}
