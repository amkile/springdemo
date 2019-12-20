package com.yang.mapper;

import com.yang.entity.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ygl
 * @description
 * @date 2019/12/18
 */
@Mapper
public interface TestMapper {

    List<Test> selectAll();

    void insert(Test test);
}
