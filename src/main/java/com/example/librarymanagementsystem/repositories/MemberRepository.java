package com.example.librarymanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.librarymanagementsystem.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
