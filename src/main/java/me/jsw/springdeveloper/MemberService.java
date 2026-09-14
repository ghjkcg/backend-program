package me.jsw.springdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MemberService {
    @Autowired
    private MemberRepository memberRepository;


    //멤버 테이블에 있는 모든 레코드들을 읽어서 반환

    public List<Member> getAllMember(){
       return memberRepository.findAll();
    }
}
