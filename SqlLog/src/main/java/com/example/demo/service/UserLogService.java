package com.example.demo.service;

import com.example.demo.DTO.UserLogDTO;

public interface UserLogService {

    /**
     * 插入用户操作日志
     * @param userLogDTO
     * @return
     */
    Boolean addSysLog(UserLogDTO userLogDTO);
}
