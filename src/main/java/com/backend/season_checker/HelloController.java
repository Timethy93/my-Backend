package com.backend.season_checker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping(path = "/doof", params = "name")  
    public String index(String name) {
        return name + " ist doof";
    }
}
