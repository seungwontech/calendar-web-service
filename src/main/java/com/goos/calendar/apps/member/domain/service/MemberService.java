package com.goos.calendar.apps.member.domain.service;

import com.goos.calendar.apps.member.domain.model.dto.MemberInfo;
import com.goos.calendar.apps.member.domain.model.dto.command.CreateMemberCommand;
import com.goos.calendar.apps.member.domain.model.entity.Member;
import com.goos.calendar.apps.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberInfo createMember(CreateMemberCommand command) {
        Member member = Member.create(command.memberId(), command.memberName(), command.phoneNumber(), command.email());
        Member savedmember = memberRepository.save(member);
        return MemberInfo.from(savedmember);
    }
}
