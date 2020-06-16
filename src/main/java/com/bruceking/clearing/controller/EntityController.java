package com.bruceking.clearing.controller;

import com.bruceking.clearing.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller")
public class EntityController {

    @Autowired
    private EntityService entityService;
}
