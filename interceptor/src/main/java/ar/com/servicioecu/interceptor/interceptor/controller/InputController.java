package ar.com.servicioecu.interceptor.interceptor.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.servicioecu.interceptor.interceptor.service.Greeting;


@RestController
@RequestMapping("/app")
public class InputController {

    @Autowired
    private Greeting greetingService;

    @GetMapping("/testinterceptor")
    public Map<String, String> testinterceptor(){
        return Collections.singletonMap("message", "handler del controlador");
    }
    @GetMapping("/greeting")
    public ResponseEntity<?>  greeting() throws Exception{
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);
        String s3 = new String("Hello");
        String s4 = new String("Hello");
        System.out.println(s3.equals(s4));
        System.out.println(s3);
        System.out.println(s4);
        return ResponseEntity.ok(Collections.singletonMap("Saludo",greetingService.sayHello("Hernan", "Hello World")));
    }

    @GetMapping("/greetingtoo")
    public ResponseEntity<?> geetingToo(@RequestParam String param) {
        
        return ResponseEntity.ok(Collections.singletonMap("message", "Hello World Too"));
    }
    
 
}
