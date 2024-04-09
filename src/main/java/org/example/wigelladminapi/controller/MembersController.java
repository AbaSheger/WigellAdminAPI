package org.example.wigelladminapi.controller;


import org.example.wigelladminapi.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MembersController {

    @Autowired
    private MemberService memberService;


    // List medlemmar (“/admin/members”) - All data för respektive medlem ska hämtas och presenteras i JSON-format

 /*   @RequestMapping (value = "/admin/members", method = RequestMethod.GET)
    @ResponseBody
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    } */


   // Hämta specifik medlem (“/admin/member/{id}”) - All data för specifik medlem ska hämtas och presenteras i JSON-format
 /*  @RequestMapping(value = "/admin/member/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Member> getMemberById(@PathVariable long id){
        return ResponseEntity.ok(memberService.getMemberById(id));
    } */


   /* Uppdatera en existerande medlems uppgifter (“/admin/updatemember/{id}”)
     - Data för medlemmen ska uppdateras (Det är även okej att göra en variant av denna endpoint så att endast en body skickas till endpointen (“/admin/updatemember”)) */

 /*   @RequestMapping(value = "/admin/updatemember/{id}", method = RequestMethod.PUT)

    public ResponseEntity<Member> updateMember(@PathVariable long id, @RequestBody  Member member){
        return ResponseEntity.ok(memberService.updateMember(id, member));
    }  */
/*
    //Lägga till ny medlem (“/admin/addmember”) - Ny medlem läggs till i databasen // return a simple string"Ny medlem tillagd
    @RequestMapping(value = "/admin/addmember", method = RequestMethod.POST)

    public ResponseEntity<String> addMember( @RequestBody Member member){

        memberService.addMember(member);

        return new ResponseEntity<>("Ny medlem tillagd", HttpStatus.CREATED);
    } */



    // Ta bort medlem (“/admin/deletemember/{id}”) - Medlem med ett visst id raderas från databasen
/*
    @RequestMapping(value = "/admin/deletemember/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<String> deleteMemberById(@PathVariable long id){
        memberService.deleteMember(id);
        return new ResponseEntity<>("Medlem raderad!", HttpStatus.OK);
    }


    // Sökvägen till denna demosida ska vara (“/admin/deletemember”) // all members data will be presnted and // we have a delete button //  */







   @GetMapping (value = "/")         // can we add thymeleaf to list them               // can we add two methods for the thyemeleaf
    public String listMemebertoDelete(Model model){


        model.addAttribute("members", memberService.getAllMembers());

        return "/deleteMember";
    }


   @GetMapping (value = "/admin/deletemember/{id}")
    public String deleteMember(@PathVariable ("id") long id, Model model){

        memberService.deleteMember(id);
        //update our view
        model.addAttribute("members", memberService.getAllMembers());
        return "/deleteMember";
    }











}
