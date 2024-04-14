package org.example.wigelladminapi.controllers;


import org.example.wigelladminapi.entities.Member;
import org.example.wigelladminapi.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class MembersController {

    @Autowired
    private MemberService memberService;




    @GetMapping("/members")
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }


    @GetMapping("/member/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable long id){
        return ResponseEntity.ok(memberService.getMemberById(id));
    }



    @PutMapping ("/updatemember/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable long id, @RequestBody  Member member){
        return ResponseEntity.ok(memberService.updateMember(id, member));
    }

    @PostMapping("/addmember")
    public ResponseEntity<String> addMember( @RequestBody Member member){

        memberService.addMember(member);

        return new ResponseEntity<>("Ny medlem tillagd", HttpStatus.CREATED);
    }


    @DeleteMapping("/deletemember/{id}")
    public ResponseEntity<String> deleteMemberById(@PathVariable long id){
        memberService.deleteMember(id);
        return new ResponseEntity<>("Medlem raderad!", HttpStatus.OK);
    }


















}
