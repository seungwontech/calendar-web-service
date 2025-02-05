package com.goos.calendar.apps.login.domain.service;

import com.goos.calendar.apps.login.domain.dto.CustomUserDetails;
import com.goos.calendar.apps.member.domain.model.entity.Member;
import com.goos.calendar.apps.member.infra.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberRepository.findByEmail(username);
        if (member != null) {
            return new CustomUserDetails(member);
        }
        return null;
    }
}
