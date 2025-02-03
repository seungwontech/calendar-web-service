package com.goos.calendar.apps.member.domain.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "member_id", nullable = false)
    private String memberId;

    @Column(name = "member_pw", nullable = false)
    private String memberPw;

    @Column(name = "member_name", nullable = false)
    private String memberName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public static Member of(Long id, String memberId, String memberPw, String memberName, String phoneNumber, String email, LocalDateTime createdAt) {
        return new Member(id, memberId, memberPw, memberName, phoneNumber, email, createdAt);
    }

    public static Member create(String memberId, String memberPw, String memberName, String phoneNumber, String email) {
        return new Member(null, memberId, memberPw, memberName, phoneNumber, email, LocalDateTime.now());
    }

}
