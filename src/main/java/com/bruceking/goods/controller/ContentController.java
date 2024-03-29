package com.bruceking.goods.controller;


import com.bruceking.goods.Service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class ContentController {


    @Autowired
    ContentService contentService;

    @GetMapping("/search/{keyword}/{pageNo}")
    public List<Map<String, Object>> search(@PathVariable("keyword") String keyword,
                                            @PathVariable("pageNo") int pageNo) throws IOException {

//System.out.println("============");
     return  contentService.searchPage(keyword,pageNo,10);
    }
}
