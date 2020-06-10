package com.bruceking.elasticsearchapi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

    @GetMapping({"/","goodsIndex"})
    public String indexController(){
        return "goodsIndex";
    }
}
