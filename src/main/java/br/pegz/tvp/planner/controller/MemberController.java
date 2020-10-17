package br.pegz.tvp.planner.controller;

import br.pegz.tvp.planner.model.Member;
import br.pegz.tvp.planner.model.MemberId;
import br.pegz.tvp.planner.model.MemberValue;
import br.pegz.tvp.planner.repository.MemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.UUID;

@RequestMapping("/access")
@RestController
public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public ResponseEntity<MemberValue> createMember(@RequestBody MemberValue memberValue) {
        memberRepository.save(new Member(new MemberId(UUID.randomUUID().toString(), memberValue.getTeamId()),
                memberValue.getTeamId(), memberValue.getName(), new HashSet<>()));
        return ResponseEntity.ok(memberValue);
    }
}
