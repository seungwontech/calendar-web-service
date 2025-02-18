package com.goos.calendar.apps.member.domain.model.dto;

import com.goos.calendar.apps.member.domain.model.entity.Member;

import java.time.LocalDateTime;

public record MemberInfo(
        Long id
        , String memberPw
        , String memberName
        , String phoneNumber
        , String email
        , String role
        , LocalDateTime createdAt) {
    public static MemberInfo from(Member member) {
        return new MemberInfo(
                member.getId()
                , member.getMemberPw()
                , member.getMemberName()
                , member.getPhoneNumber()
                , member.getEmail()
                , member.getRole()
                , member.getCreatedAt());
    }
}
