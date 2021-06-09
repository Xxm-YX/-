package com.example.domain;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {

    private List<T> result;
    //新增和分页相关的三个字段

    private Integer pageNum;
    private Integer pageSize;
    private Long total;
}
