package com.fiona.service.impl;

import com.fiona.dao.IUserDao;
import com.fiona.model.User;
import com.fiona.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;
    public User selectUser(int userId) {
        return this.userDao.selectUser(userId);
    }

}