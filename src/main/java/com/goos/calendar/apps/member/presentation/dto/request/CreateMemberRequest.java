package com.goos.calendar.apps.member.presentation.dto.request;

import com.goos.calendar.apps.member.domain.model.dto.command.CreateMemberCommand;

public record CreateMemberRequest(String userId, String userName, String phoneNumber, String email) {
    public CreateMemberCommand toCommand() {
        return new CreateMemberCommand(userId, userName, phoneNumber, email);
    }
}