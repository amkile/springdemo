package com.yang.controller;

import com.yang.entity.Test;
import com.yang.entity.YangProperties;
import com.yang.mapper.TestMapper;
import com.yang.service.defds.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ygl
 * @description
 * @date 2019/12/18
 */
@RestController
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class Hello {

    @Resource
    private TestService testService;

    @Resource
    private YangProperties yangProperties;

    @RequestMapping("/hello")
    public String hello(){
        List<Test> tests = testService.getTestAll();
//        Test test = new Test();
//        test.setName("ok");
//        testService.save(test);
//        throw new RuntimeException("");
        return yangProperties.toString();
    }

}
