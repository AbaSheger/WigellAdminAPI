package org.example.wigelladminapi.services;


import org.example.wigelladminapi.Repositories.MemberRepository;
import org.example.wigelladminapi.exceptions.ResourceNotFoundException;
import org.example.wigelladminapi.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class MemberService implements MemberInterface {



    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(long id) {
        //get car by add
        // if member not found throw ResourceNotFoundException

        Optional<Member> existingMember = memberRepository.findById(id);

        if(existingMember.isPresent()){
            return existingMember.get();
        } else {
            throw new ResourceNotFoundException("Member", "id", id);
        }




    }

    @Override
    public Member addMember(Member member) {

        //check if member exists
        // if it doesnt exist save the member add  new member
        //  map it with a new address




        if(member.getId() == 0){

            return memberRepository.save(member);
        } else {
            Optional<Member> existingMember = memberRepository.findById(member.getId());

            if(existingMember.isPresent()){
                throw new ResourceNotFoundException("Member", "id", member.getId());
            } else {
                return memberRepository.save(member);
            }
        }

    }


   @Override
    public Member updateMember(long id, Member member) {

        //check if the member exists
        // if it exists update the member
        // if it does not exist throw ResourceNotFoundException
        // when member gets updated address shouldnt be null

      /* Optional<Member> existingMember = memberRepository.findById(id);

        if(existingMember.isPresent()){
            Member updatedMember = existingMember.get();
            updatedMember.setFirstName(member.getFirstName());
            updatedMember.setLastName(member.getLastName());
            updatedMember.setEmail(member.getEmail());
            updatedMember.setPhone(member.getPhone());
            updatedMember.setDateOfBirth(member.getDateOfBirth());
            updatedMember.setAddress(member.getAddress());


            if (member.getAddress() != null) {
                updatedMember.setAddress(member.getAddress());
            }
            return memberRepository.save(updatedMember);
        } else {
            throw new ResourceNotFoundException("Member", "id", id);
        } */

       memberRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Member", "id", id));

       return memberRepository.save(member);


    }

   /* @Override
    public Member updateMember(long id, Member member) {
        Optional<Member> existingMember = memberRepository.findById(id);

        if(existingMember.isPresent()){
            Member updatedMember = existingMember.get();
            updatedMember.setFirstName(member.getFirstName() != null ? member.getFirstName() : updatedMember.getFirstName());
            updatedMember.setLastName(member.getLastName() != null ? member.getLastName() : updatedMember.getLastName());
            updatedMember.setEmail(member.getEmail() != null ? member.getEmail() : updatedMember.getEmail());
            updatedMember.setPhone(member.getPhone() != null ? member.getPhone() : updatedMember.getPhone());
            updatedMember.setDateOfBirth(member.getDateOfBirth() != null ? member.getDateOfBirth() : updatedMember.getDateOfBirth());
            updatedMember.setAddress(member.getAddress() != null ? member.getAddress() : updatedMember.getAddress());

            return memberRepository.save(updatedMember);
        } else {
            throw new ResourceNotFoundException("Member", "id", id);
        }
    } */



    @Override

    public void  deleteMember(long id) {
        //delete member
        // if member not found throw ResourceNotFoundException

       Optional<Member> existingMember = memberRepository.findById(id);
        if (existingMember.isPresent()) {
            memberRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Member", "id", id);
        }

    }

}
