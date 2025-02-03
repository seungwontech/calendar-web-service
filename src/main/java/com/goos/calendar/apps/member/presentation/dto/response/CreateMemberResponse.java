package com.goos.calendar.apps.member.presentation.dto.response;

import com.goos.calendar.apps.member.domain.model.dto.MemberInfo;

public record CreateMemberResponse(Long id, String memberId, String memberName) {
    public static CreateMemberResponse from(MemberInfo memberInfo) {
        return new CreateMemberResponse(memberInfo.id(), memberInfo.memberId(), memberInfo.memberName());
    }
}