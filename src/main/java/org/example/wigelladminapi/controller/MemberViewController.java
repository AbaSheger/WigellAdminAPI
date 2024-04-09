package org.example.wigelladminapi.controller;

import org.example.wigelladminapi.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class MemberViewController {
    @Autowired
    private MemberService memberService;

 //Display members with a delete option

    @GetMapping ("/deletemember")
    public String listMembersToDelete(Model model) {
        model.addAttribute("members", memberService.getAllMembers());
        return "deletemember";
    }

    //Deletion handled without redirect
    @GetMapping ("deletemember/{id}")
    public String deleteMember(@PathVariable long id, Model model){
        memberService.deleteMember(id);
        model.addAttribute("members", memberService.getAllMembers());
        return "deletemember"; //return to the view with the updated list
    }


}
