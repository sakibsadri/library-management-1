package com.example.librarymanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.librarymanagementsystem.entity.Borrowing;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
}
