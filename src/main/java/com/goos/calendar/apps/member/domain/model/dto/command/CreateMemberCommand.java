package com.goos.calendar.apps.member.domain.model.dto.command;

public record CreateMemberCommand(String userId, String userName, String phoneNumber, String email) {}
