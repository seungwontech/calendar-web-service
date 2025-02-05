package com.goos.calendar.apps.member.domain.service;

import com.goos.calendar.apps.member.domain.model.dto.MemberInfo;
import com.goos.calendar.apps.member.domain.model.dto.command.CreateMemberCommand;
import com.goos.calendar.apps.member.domain.model.entity.Member;
import com.goos.calendar.apps.member.infra.repository.MemberRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public MemberInfo createMember(CreateMemberCommand command) {
        Member member = memberRepository.findByEmail(command.email());
        if (member != null) {
            throw new UsernameNotFoundException("User not found with email: " + command.email());
        }

        member = Member.create(bCryptPasswordEncoder.encode(command.memberPw())
                , command.memberName()
                , command.phoneNumber()
                , command.email()
        );
        Member savedmember = memberRepository.save(member);
        return MemberInfo.from(savedmember);
    }
}
