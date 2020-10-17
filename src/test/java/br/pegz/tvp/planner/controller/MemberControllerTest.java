package br.pegz.tvp.planner.controller;

import br.pegz.tvp.planner.model.Member;
import br.pegz.tvp.planner.model.MemberValue;
import br.pegz.tvp.planner.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberControllerTest {

    @InjectMocks
    private MemberController memberController;

    @Mock
    private MemberRepository memberRepository;

    @Test
    void createMember() {
        MemberValue memberValue = new MemberValue("og-looney-tunes", "wile.e.coyote");
        ResponseEntity<MemberValue> response = memberController.createMember(memberValue);
        verify(memberRepository).save(any(Member.class));
        assertNotNull(response.getBody());
        assertNotNull(response.getStatusCode());
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(response.getBody().getTeamId(), memberValue.getTeamId());
        assertEquals(response.getBody().getName(), memberValue.getName());
    }
}
