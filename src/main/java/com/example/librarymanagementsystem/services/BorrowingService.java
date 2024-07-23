package com.example.librarymanagementsystem.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarymanagementsystem.entity.Borrowing;
import com.example.librarymanagementsystem.repositories.BorrowingRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    public Borrowing issueBook(Borrowing borrowing) {
        return borrowingRepository.save(borrowing);
    }

    public List<Borrowing> getAllBorrowings() {
        return borrowingRepository.findAll();
    }

    public Optional<Borrowing> getBorrowingById(Long id) {
        return borrowingRepository.findById(id);
    }

    public Borrowing updateBorrowing(Borrowing borrowing) {
        if (!borrowingRepository.existsById(borrowing.getId())) {
            throw new IllegalArgumentException("Borrowing record not found");
        }
        return borrowingRepository.save(borrowing);
    }

    public void deleteBorrowing(Long id) {
        if (!borrowingRepository.existsById(id)) {
            throw new IllegalArgumentException("Borrowing record not found");
        }
        borrowingRepository.deleteById(id);
    }
}


















//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.librarymanagementsystem.entity.Borrowing;
//import com.example.librarymanagementsystem.repositories.BorrowingRepository;
//
//@Service
//public class BorrowingService {
//
//    @Autowired
//    private BorrowingRepository borrowingRepository;
//
//    public Borrowing issueBook(Borrowing borrowing) {
//        return borrowingRepository.save(borrowing);
//    }
//
//    public List<Borrowing> getAllBorrowings() {
//        return borrowingRepository.findAll();
//    }
//
//    public Optional<Borrowing> getBorrowingById(Long id) {
//        return borrowingRepository.findById(id);
//    }
//
//    public Borrowing updateBorrowing(Borrowing borrowing) {
//        return borrowingRepository.save(borrowing);
//    }
//
//    public void deleteBorrowing(Long id) {
//        borrowingRepository.deleteById(id);
//    }
//}

