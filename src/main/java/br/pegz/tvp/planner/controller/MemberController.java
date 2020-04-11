package br.pegz.tvp.planner.controller;

import br.pegz.tvp.planner.model.Member;
import br.pegz.tvp.planner.model.MemberValue;
import br.pegz.tvp.planner.repository.MemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.UUID;

@RestController
public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public ResponseEntity<MemberValue> createMember(@RequestBody MemberValue memberValue) {
        memberRepository.save(new Member(UUID.randomUUID().toString(),
                memberValue.getTeamId(), memberValue.getName(), new HashSet<>()));
        return ResponseEntity.ok(memberValue);
    }
}
