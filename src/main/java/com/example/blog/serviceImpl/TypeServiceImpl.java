package com.example.blog.serviceImpl;

import com.example.blog.entity.Type;
import com.example.blog.mapper.TypeMapper;
import com.example.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TypeServiceImpl implements TypeService {

    private final TypeMapper typeMapper;

    public TypeServiceImpl(TypeMapper typeMapper) {
        this.typeMapper = typeMapper;
    }

    /**
     * 从整个表中 分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public Map queryTypesByPage(Integer pageNo, Integer pageSize) {
        return queryTypesByPage(null,pageNo,pageSize);
    }

    /**
     * 根据相关字段 分页查询符合条件的类型
     * @param type  对象实体
     * @param pageNo 第几页  从 1 开始， 因为0 代表全部
     * @param pageSize 每页条数
     * @return
     */
    @Override
    public Map queryTypesByPage(Type type, Integer pageNo, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        List<Type> types=typeMapper.pageQuery(type,pageNo, pageSize);
        Integer totalNum=typeMapper.queryTotalNum(type);
        map.put("types",types);
        map.put("totalNum",totalNum);
        return map;
    }

    @Override
    public Integer saveType(Type type) {
        return typeMapper.insert(type);
    }

    @Override
    public Integer deleteTypeByIds(int[] ids) {
        return typeMapper.deleteByIds(ids);
    }


}
