package com.example.librarymanagementsystem.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.services.BookService;

@RestController  // Indicates that this class is a REST controller
//Maps HTTP requests to /api/books to the methods in this controller
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
    	  // Adds the new book using the bookService and returns the added book in the response
        Book newBook = bookService.addBook(book);
        return ResponseEntity.ok(newBook);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
    	// Retrieves all books using the bookService and returns them in the response
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable Long id) {
    	  // Retrieves the book by ID using the bookService and returns it in the response
        Optional<Book> book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        // Sets the ID of the book to be updated and updates it using the bookService
    	book.setId(id);
        Book updatedBook = bookService.updateBook(book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    	// Deletes the book by ID using the bookService
        bookService.deleteBook(id);
     // Returns a response with no content to indicate successful deletion
        return ResponseEntity.noContent().build();
    }
}