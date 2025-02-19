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
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_pw", nullable = false)
    private String memberPw;

    @Column(name = "member_name", nullable = false)
    private String memberName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public static Member of(Long id, String memberPw, String memberName, String phoneNumber, String email, String role, LocalDateTime createdAt) {
        return new Member(id, memberPw, memberName, phoneNumber, email, role, createdAt);
    }

    public static Member create(String memberPw, String memberName, String phoneNumber, String email) {
        return new Member(null, memberPw, memberName, phoneNumber, email, "ROLE_ADMIN", LocalDateTime.now());
    }

    public static Member ofEmailAndRole(String email, String role) {
        return new Member(null, "tempPassword", "Unknown", "000-0000-0000", email, role, LocalDateTime.now());
    }

}
