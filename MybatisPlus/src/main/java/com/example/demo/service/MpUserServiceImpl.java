package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.MpUserMapper;
import com.example.demo.domain.MpUserPojo;
import org.springframework.stereotype.Service;

@Service
public class MpUserServiceImpl extends ServiceImpl<MpUserMapper, MpUserPojo> implements MpUserService {
}