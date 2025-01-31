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

    public MemberInfo createUser(CreateMemberCommand command) {
        Member user = Member.create(command.userId(), command.userName(), command.phoneNumber(), command.email());
        Member savedUser = memberRepository.save(user);
        return MemberInfo.from(savedUser);
    }
}
