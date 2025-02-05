package com.goos.calendar.apps.member.domain.model.dto.command;

public record CreateMemberCommand(String memberPw, String memberName, String phoneNumber, String email, String Role) {}
