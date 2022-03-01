package com.example.neo4jvisdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("index")
    public String index(){
        return "neo4j";
    }
}
