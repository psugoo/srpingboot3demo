package com.wtkj.springbootdemo.action.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class PersonAction {


    @RequestMapping("/helloword")
    public String helloword(){
        return "Hello World";
    }
}
