package com.ssm.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface CityDao {
    String queryById(String id);
}