package me.jsw.springdeveloper;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //의존성 주입

public class MemberService {
    private final MemberRepository memberRepository;
 ;
    public Member saveMember(Member member){
        return memberRepository.save(member);
    }

    public List<Member> findALLMembers(){
        return memberRepository.findAll();
    }


    //멤버 테이블에 있는 모든 레코드들을 읽어서 반환

    public List<Member> getAllMember(){
       return memberRepository.findAll();
    }

}
