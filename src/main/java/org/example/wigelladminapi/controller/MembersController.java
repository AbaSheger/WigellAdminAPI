package org.example.wigelladminapi.controller;


import org.example.wigelladminapi.model.Member;
import org.example.wigelladminapi.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class MembersController {

    @Autowired
    private MemberService memberService;


    // List medlemmar (“/admin/members”) - All data för respektive medlem ska hämtas och presenteras i JSON-format


    @GetMapping("/members")
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }


   // Hämta specifik medlem (“/admin/member/{id}”) - All data för specifik medlem ska hämtas och presenteras i JSON-format
    @GetMapping("/member/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable long id){
        return ResponseEntity.ok(memberService.getMemberById(id));
    }


   /* Uppdatera en existerande medlems uppgifter (“/admin/updatemember/{id}”)
     - Data för medlemmen ska uppdateras (Det är även okej att göra en variant av denna endpoint så att endast en body skickas till endpointen (“/admin/updatemember”)) */

    @PutMapping ("/updatemember/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable long id, @RequestBody  Member member){
        return ResponseEntity.ok(memberService.updateMember(id, member));
    }

    //Lägga till ny medlem (“/admin/addmember”) - Ny medlem läggs till i databasen // return a simple string"Ny medlem tillagd
    @PostMapping("/addmember")
    public ResponseEntity<String> addMember( @RequestBody Member member){

        memberService.addMember(member);

        return new ResponseEntity<>("Ny medlem tillagd", HttpStatus.CREATED);
    }



    // Ta bort medlem (“/admin/deletemember/{id}”) - Medlem med ett visst id raderas från databasen
    @DeleteMapping("/deletemember/{id}")
    public ResponseEntity<String> deleteMemberById(@PathVariable long id){
        memberService.deleteMember(id);
        return new ResponseEntity<>("Medlem raderad!", HttpStatus.OK);
    }


















}
