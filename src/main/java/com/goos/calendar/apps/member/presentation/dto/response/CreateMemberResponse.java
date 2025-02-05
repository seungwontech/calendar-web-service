package com.goos.calendar.apps.member.presentation.dto.response;

import com.goos.calendar.apps.member.domain.model.dto.MemberInfo;

public record CreateMemberResponse(Long id, String memberName) {
    public static CreateMemberResponse from(MemberInfo memberInfo) {
        return new CreateMemberResponse(memberInfo.id(), memberInfo.memberName());
    }
}