package com.springBoot.training.demo.crtls;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello () {
        return "Hello Java Spring boot!!!";
    }
}
