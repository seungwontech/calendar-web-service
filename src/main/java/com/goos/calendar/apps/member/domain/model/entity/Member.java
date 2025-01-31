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

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public static Member of(Long id, String userId, String userName, String phoneNumber, String email, LocalDateTime createdAt) {
        return new Member(id, userId, userName, phoneNumber, email, createdAt);
    }

    public static Member create(String userId, String userName, String phoneNumber, String email) {
        return new Member(null, userId, userName, phoneNumber, email, LocalDateTime.now());
    }

}
