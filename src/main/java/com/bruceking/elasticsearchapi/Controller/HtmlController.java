package com.bruceking.elasticsearchapi.Controller;

import com.bruceking.elasticsearchapi.service.contentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HtmlController {

    @Autowired
    private contentService contentService;


    @GetMapping("/parse/{keyword}")
    public Boolean parse(@PathVariable("keyword") String keyword) throws IOException {

        System.out.println("parseparse");
        return contentService.parseContent(keyword);

    }

}
