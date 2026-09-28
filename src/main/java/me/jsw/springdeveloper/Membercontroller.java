package me.jsw.springdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/member")

public class Membercontroller {
    @Autowired
    private MemberService memberService;
    //요청을 받아서 적절한 비지니스 로직으로 연결
    @PostMapping("/member")
    public ResponseEntity<Member> createMember(@RequestBody Member member) {//회원 정보를 등록하는 요청
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.saveMember(member));
    }

    //http://localhost:8080/member 요청과 메서드를 연결
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers(){
        return ResponseEntity.ok(memberService.findALLMembers());

    }

    // 회원정보를 등록하는 요청
    // http://localhost:8080/member 요청을 post방식으로 했을 때 회원 등록을 처리하도록 구현


}
