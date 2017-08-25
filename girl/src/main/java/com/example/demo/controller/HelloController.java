package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gzf on 2017/8/10.
 */
@RestController
@RequestMapping("/hello")

//@RestController等同于@Controller和@ResponseBody
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;

    //@RequestMapping(value = "/say",method = RequestMethod.GET)
    @GetMapping(value = "/say")//@GetMapping等同于上面的注解
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        //@RequestParam注解是获取请求参数的值，required是参数是否必传，defaultValue是默认值
        String a ="Hello Spring Boot!";
        return "id = "+id;
    }
}
