package me.jsw.springdeveloper;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello")
    public String hello() {
        return  "Hello World!";
    }
    @GetMapping("/test")
    public String test() {
        return "Hello Everyone!";
    }
    @GetMapping("/Asuka")
    public String Asuka() {
        return "I Love you";
    }

    @PostMapping("/test")
    public String postTest(){
        return "Post Test response!!!!";
    }

    @PostMapping("/test")
    public String deleteTest(){
        return "Delete Test response!!!!";
    }

    @PutMapping ("/test")
    public String putTest(){
        return "Put Test response!!!!";
    }

    //http://localhost:8080/test -> "Hello Everyone!!"
}


