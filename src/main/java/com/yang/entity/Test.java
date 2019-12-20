package com.yang.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author ygl
 * @description
 * @date 2019/12/18
 */
@Data
public class Test  implements Serializable {
    private static final long serialVersionUID = 7411379235932514461L;

    private int id;
    private String group1;
    private String group2;
    private int grade;
    private String name;

}
