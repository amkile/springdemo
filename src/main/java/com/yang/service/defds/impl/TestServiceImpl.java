package com.yang.service.defds.impl;

import com.yang.entity.Test;
import com.yang.mapper.TestMapper;
import com.yang.service.defds.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ygl
 * @description
 * @date 2019/12/19
 */
@Service
@Slf4j
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;


    @Override
    public List<Test> getTestAll() {
        return testMapper.selectAll();
    }

    @Override
    public void save(Test test) {
        testMapper.insert(test);
    }
}
