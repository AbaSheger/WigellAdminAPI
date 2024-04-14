package org.example.wigelladminapi.controllers;

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



    @GetMapping ("/deletemember")
    public String listMembersToDelete(Model model) {
        model.addAttribute("members", memberService.getAllMembers());

        return "deletemember";
    }

    @GetMapping ("deletemember/{id}")
    public String deleteMember(@PathVariable long id, Model model){
        memberService.deleteMember(id);
        model.addAttribute("members", memberService.getAllMembers());
        return "deletemember";
    }


}
