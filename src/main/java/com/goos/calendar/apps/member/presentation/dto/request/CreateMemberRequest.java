package com.goos.calendar.apps.member.presentation.dto.request;

import com.goos.calendar.apps.member.domain.model.dto.command.CreateMemberCommand;

public record CreateMemberRequest(String memberId, String memberPw,String memberName, String phoneNumber, String email) {
    public CreateMemberCommand toCommand() {
        return new CreateMemberCommand(memberId, memberPw, memberName, phoneNumber, email);
    }
}