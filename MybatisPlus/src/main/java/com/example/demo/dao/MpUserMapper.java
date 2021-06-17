package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.domain.MpUserPojo;

/**
 * 继承Mybatis——Plus提供的BaseMapper 提供了增删改查以及分页方法，基本已经满足日常开发
 */
public interface MpUserMapper extends BaseMapper<MpUserPojo> {
}