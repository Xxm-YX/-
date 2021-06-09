package com.example.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 一般处理  分页
 */
public class PageResult<T> implements Serializable {

    private Integer code;
    private String message;
    private List<T> data;
    //新增和分页相关的三个字段

    private Integer page;
    private Integer pageSize;
    private Long total;

    public PageResult(List<T> data, Integer page, Integer pageSize, Long total) {
        this.code = ExceptionCodeEnum.SUCCESS.getCode();
        this.message = ExceptionCodeEnum.SUCCESS.getDesc();
        this.data = data;
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
    }


    public static <T> PageResult<T> success(Page<T> page){
        if(page != null){
            return new PageResult<>(page.getResult(), page.getPageNum(), page.getPageSize(), page.getTotal());
        }else {
            return new PageResult<>(new ArrayList<T>(),0,1,10L);
        }
    }
}
