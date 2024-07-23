package com.example.librarymanagementsystem.controllers;

import com.example.librarymanagementsystem.entity.Member;
import com.example.librarymanagementsystem.services.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
    	 // Adds the new member using the memberService and returns the added member in the response
        Member newMember = memberService.addMember(member);
        return ResponseEntity.ok(newMember);
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        // Retrieves all members using the memberService and returns them in the response
        List<Member> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Member>> getMemberById(@PathVariable Long id) {
    	 // Retrieves the member by ID using the memberService and returns it in the response
        Optional<Member> member = memberService.getMemberById(id);
        return ResponseEntity.ok(member);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member member) {
    	// Sets the ID of the member to be updated and updates it using the memberService
    	member.setId(id);
        Member updatedMember = memberService.updateMember(member);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
    	// Deletes the member by ID using the memberService
    	memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}