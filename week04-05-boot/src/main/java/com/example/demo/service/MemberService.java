package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원 가입: 같은 이름이 있으면 예외, 없으면 저장하고 id 반환
    public Long join(Member member) {
        if (memberRepository.findByName(member.getName()).isPresent()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
        return memberRepository.save(member).getId();
    }

    // id로 회원 조회
    public Optional<Member> findOne(Long id) {
        return memberRepository.findById(id);
    }
}