package com.goos.calendar.apps.member.infra.repository;

import com.goos.calendar.apps.member.domain.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
}
