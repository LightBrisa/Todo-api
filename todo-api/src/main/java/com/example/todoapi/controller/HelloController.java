package com.example.todoapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    // 主页：直接访问 http://localhost:8080 就有响应
    @GetMapping("/")
    public String index() {
        return "Todo API is up.";
    }

    // 演示接口： http://localhost:8080/api/hello?name=Java
    @GetMapping("/api/hello")
    public String hello(@RequestParam(defaultValue = "world") String name) {
        return "Hello, " + name + "!";
    }
}
