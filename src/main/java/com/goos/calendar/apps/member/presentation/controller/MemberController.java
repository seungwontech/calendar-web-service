package com.goos.calendar.apps.member.presentation.controller;

import com.goos.calendar.apps.member.presentation.dto.request.CreateMemberRequest;
import com.goos.calendar.apps.member.presentation.dto.response.CreateMemberResponse;
import com.goos.calendar.apps.member.domain.model.dto.MemberInfo;
import com.goos.calendar.apps.member.domain.model.dto.command.CreateMemberCommand;
import com.goos.calendar.apps.member.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class MemberController {

    private final MemberService userService;

    @PostMapping
    public ResponseEntity<CreateMemberResponse> createMember(@RequestBody CreateMemberRequest request){
        CreateMemberCommand command = request.toCommand();
        MemberInfo result = userService.createUser(command);
        return ResponseEntity.ok(CreateMemberResponse.from(result));
    }

}
