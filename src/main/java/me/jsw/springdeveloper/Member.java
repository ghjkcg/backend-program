package me.jsw.springdeveloper;
//백엔드는 클라이언트의 요청을 받아서 비지니스 로직을 수행하고 그 결과를 클라이언트에게 전송
//controller(Spring Boot에서 요청을 받는 놈,인터페이스(고객기 가장 먼저 마주하는)>Service(비지니스 로직,회원 가입 같은 정보를 받아)>Repository(연속 계층,db에 저장)
//Entity 클래스는 테이블 생성해주는거
//Getter프라이빗 변수를 외부에서 읽어 올 수가 없어서 호풀하기 위해 사용
import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private long id;
    @Column(name="name", nullable = false)
    private String name;
}
