package com.yang.service.defds;

import com.yang.entity.Test;

import java.util.List;

public interface TestService {


    List<Test> getTestAll();

    void save(Test test);

}
