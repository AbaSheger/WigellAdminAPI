package org.example.wigelladminapi.services;


import jakarta.transaction.Transactional;
import org.example.wigelladminapi.Repository.MemberRepository;
import org.example.wigelladminapi.exceptions.ResourceNotFoundException;
import org.example.wigelladminapi.model.Member;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MemberService implements MemberInterface {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberService.class);

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
        LOGGER.info("deleteMember method called with id: {}", id);
        Optional<Member> existingMember = memberRepository.findById(id);

        if(existingMember.isPresent()){
            return existingMember.get();
        } else {
            throw new ResourceNotFoundException("Member", "id", id);
        }




    }

    @Override
    public Member addMember(Member member) {

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
    public Member updateMember(long id, Member member) {  // question: why should we pass the id as a parameter when we can get it from the member object itself?

        //check if the member exists
        // if it exists update the member
        // if it does not exist throw ResourceNotFoundException

        if (memberRepository.existsById(member.getId())) {
            return memberRepository.save(member);
        } else {
            throw new ResourceNotFoundException("Member", "id", member.getId());
        }


    }


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
