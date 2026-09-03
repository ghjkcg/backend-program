package me.jsw.springdeveloper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication   //애너테이션
public class SpringBootDeveloperApplication {
    public static void main(String[] args){
        //스프링 부트 실행(백엔드 서버를 구현할때 이거를 반드시 먼저 해줘야함)
        SpringApplication.run(SpringBootDeveloperApplication.class, args);
    }
}
