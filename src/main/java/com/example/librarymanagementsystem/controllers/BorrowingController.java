package com.example.librarymanagementsystem.controllers;


import com.example.librarymanagementsystem.entity.Borrowing;
import com.example.librarymanagementsystem.services.BorrowingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//Maps HTTP requests to /api/borrowings to the methods in this controller
@RequestMapping("/api/borrowings")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    @PostMapping
    public ResponseEntity<Borrowing> issueBook(@RequestBody Borrowing borrowing) {
    	// Issues the book borrowing using the borrowingService and returns the new borrowing in the response
        Borrowing newBorrowing = borrowingService.issueBook(borrowing);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBorrowing);
    }

    @GetMapping
    public ResponseEntity<List<Borrowing>> getAllBorrowings() {
    	// Retrieves all borrowings using the borrowingService and returns them in the response
        List<Borrowing> borrowings = borrowingService.getAllBorrowings();
        return ResponseEntity.ok(borrowings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Borrowing> getBorrowingById(@PathVariable Long id) {
    	// Retrieves the borrowing by ID using the borrowingService and returns it in the response
        Optional<Borrowing> borrowing = borrowingService.getBorrowingById(id);
        // If borrowing is present, return it with OK status; otherwise, return Not Found status
        return borrowing.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Borrowing> updateBorrowing(@PathVariable Long id, @RequestBody Borrowing borrowing) {
    	// Check if the path ID and borrowing ID match, if not return Bad Request status
    	if (!id.equals(borrowing.getId())) {
            return ResponseEntity.badRequest().build();
        }
    	// Update the borrowing using the borrowingService and return the updated borrowing in the response
    	Borrowing updatedBorrowing = borrowingService.updateBorrowing(borrowing);
        return ResponseEntity.ok(updatedBorrowing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrowing(@PathVariable Long id) {
        try {
        	// Delete the borrowing by ID using the borrowingService
            borrowingService.deleteBorrowing(id);
         // Return No Content status to indicate successful deletion
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
        	// If the borrowing ID is not found, return Not Found statu
            return ResponseEntity.notFound().build();
        }
    }
}


