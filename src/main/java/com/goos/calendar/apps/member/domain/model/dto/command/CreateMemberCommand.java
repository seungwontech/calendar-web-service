package com.goos.calendar.apps.member.domain.model.dto.command;

public record CreateMemberCommand(String memberId, String memberName, String phoneNumber, String email) {}
