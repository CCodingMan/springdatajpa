package com.ljj.springdatajpa.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: ljj
 * @Date: 2019/7/25 14:49
 * @Description: 分页基本类
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 6913831082714642480L;
    /**
     * 分页页码，默认页码为1
     */
    private int page = 1;
    /**
     * 分页每页数量，默认20条
     */
    private int size = 20;
    /**
     * 排序列名称，默认id列
     */
    private String idx = "id";
    /**
     * 排序方式，默认升序
     */
    private String sort = "asc";
}
