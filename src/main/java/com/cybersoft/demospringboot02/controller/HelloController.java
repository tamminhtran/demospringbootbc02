package com.cybersoft.demospringboot02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Annotation: định nghĩa đường dẫn
 * @Controller: định nghĩa đường dẫn được dùng để trả ra nội dung html + @ResponseBody: giúp trả nội dung kiểu String
 * @RestController: định nghĩa đường dẫn, nội dung trả về string (chuyên dùng để viết API)
 */
// khai báo đường dẫn /hello và /hello/cybersoft
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("")
    public  String hello(){
        return "Hello Spring Boot";
    }
    @GetMapping("/cybersoft")
    public String helloCybersoft(){
        return "Hello Cybersoft";
    }

}
