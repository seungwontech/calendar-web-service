package com.goos.calendar.member;

import com.goos.calendar.apps.member.domain.model.dto.MemberInfo;
import com.goos.calendar.apps.member.domain.model.dto.command.CreateMemberCommand;
import com.goos.calendar.apps.member.domain.model.entity.Member;
import com.goos.calendar.apps.member.domain.service.MemberService;
import com.goos.calendar.apps.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberInfo memberInfo;

    @Test
    public void testCreateMember() {
        // given
        CreateMemberCommand createMemberCommand = new CreateMemberCommand("member123", "a1234", "John Doe", "1234567890", "john.doe@example.com");
        Member savedMember = Member.of(1L, "member123", "a1234", "John Doe", "1234567890", "john.doe@example.com", LocalDateTime.now());
        when(memberRepository.save(any(Member.class))).thenReturn(savedMember);

        // when
        MemberInfo result = memberService.createMember(createMemberCommand);

        // then
        assertNotNull(result);
        assertEquals("John Doe", result.memberName());
        assertEquals(1L, result.id());
    }
}
