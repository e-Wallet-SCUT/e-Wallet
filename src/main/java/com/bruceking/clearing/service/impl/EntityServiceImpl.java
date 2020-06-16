package com.bruceking.clearing.service.impl;

import com.bruceking.clearing.mapper.EntityMapper;
import com.bruceking.clearing.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityServiceImpl implements EntityService {

    @Autowired
    private EntityMapper entityMapper;
}
