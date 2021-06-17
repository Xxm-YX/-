package com.example.demo.service.impl;

import com.example.demo.DO.UserLogDO;
import com.example.demo.DTO.UserLogDTO;
import com.example.demo.dao.UserLogMapper;
import com.example.demo.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserLogService")
public class UserLogServiceImpl implements UserLogService {

    @Autowired
    private UserLogMapper userLogMapper;

    @Override
    public Boolean addSysLog(UserLogDTO userLogDTO) {
        UserLogDO userLogDO = new UserLogDO();
        userLogDO.setModuleCode(userLogDTO.getModuleCode());
        userLogDO.setType(userLogDTO.getType());
        userLogDO.setTitle(userLogDTO.getTitle());
        userLogDO.setOperatorId(userLogDTO.getOperatorId());
        userLogDO.setOperateTime(userLogDTO.getOperateTime());
        userLogDO.setContent(userLogDTO.getContent());
        return userLogMapper.insert(userLogDO) > 0;
    }


}
