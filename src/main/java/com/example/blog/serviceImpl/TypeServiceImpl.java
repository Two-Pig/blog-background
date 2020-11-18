package com.example.blog.serviceImpl;

import com.example.blog.entity.Type;
import com.example.blog.mapper.TypeMapper;
import com.example.blog.service.TypeService;
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
        List<List> list = typeMapper.pageQuery(type, pageNo, pageSize);
        List<Type> types=(List<Type>) list.get(0);
        int totalNum=(int)list.get(1).get(0);
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
