package com.bruceking.goods.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class payController {


    @GetMapping("/payinit/{title}/{price}")
    public ModelAndView payinit(@PathVariable("title") String title,
                                @PathVariable("price") String price){

        System.out.println("··············");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title",title);
        modelAndView.addObject("price",price);

        System.out.println(title);
        modelAndView.setViewName("pay");

        return modelAndView;

    }
}
