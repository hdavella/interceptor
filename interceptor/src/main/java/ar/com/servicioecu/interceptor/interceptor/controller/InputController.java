package ar.com.servicioecu.interceptor.interceptor.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.servicioecu.interceptor.interceptor.service.Greeting;


@RestController
@RequestMapping("/app")
public class InputController {

    @Autowired
    private Greeting greetingService;

    @GetMapping("/test")
    public Map<String, String> test(){
        return Collections.singletonMap("message", "handler del controlador");
    }
    @GetMapping("/greeting")
    public Map<String, String> greeting(){
        return Collections.singletonMap("message", "Hello World");
    }
 
}
