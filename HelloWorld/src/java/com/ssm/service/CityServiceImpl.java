package com.ssm.service;

import com.ssm.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cityService")
public class CityServiceImpl implements CityService {
    @Autowired
    CityDao cityDao;
    public String getCityName(String id) {
        return cityDao.queryById(id);
    }
}