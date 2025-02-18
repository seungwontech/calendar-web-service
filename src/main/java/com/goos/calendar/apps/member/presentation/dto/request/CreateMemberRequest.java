package com.goos.calendar.apps.member.presentation.dto.request;

import com.goos.calendar.apps.member.domain.model.dto.command.CreateMemberCommand;

public record CreateMemberRequest(String memberPw,String memberName, String phoneNumber, String email, String role) {
    public CreateMemberCommand toCommand() {
        return new CreateMemberCommand(memberPw, memberName, phoneNumber, email, role);
    }
}