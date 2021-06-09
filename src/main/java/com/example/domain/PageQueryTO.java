package com.example.domain;

import lombok.Data;

@Data
public class PageQueryTO extends BasePojo{

    private static final Integer DEFAULT_PAGE = 1;
    private static final Integer DEFAULT_PAGE_SIZE = 20;

    /**
     * 当前页数
     */
    private Integer page = DEFAULT_PAGE;

    /**
     * 每页大小
     */
    private Integer pageSize = DEFAULT_PAGE_SIZE;
}
