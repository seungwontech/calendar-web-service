package com.goos.calendar.apps.member.presentation.dto.response;

import com.goos.calendar.apps.member.domain.model.dto.MemberInfo;

public record CreateMemberResponse(Long id, String userId, String userName) {
    public static CreateMemberResponse from(MemberInfo userInfo) {
        return new CreateMemberResponse(userInfo.id(), userInfo.userId(), userInfo.userName());
    }
}