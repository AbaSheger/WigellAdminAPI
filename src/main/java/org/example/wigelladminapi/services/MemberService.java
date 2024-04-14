package org.example.wigelladminapi.services;


import org.example.wigelladminapi.Repositories.AddressRepository;
import org.example.wigelladminapi.Repositories.MemberRepository;
import org.example.wigelladminapi.entities.Address;
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

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(long id) {


        Optional<Member> existingMember = memberRepository.findById(id);

        if(existingMember.isPresent()){
            return existingMember.get();
        } else {
            throw new ResourceNotFoundException("Member", "id", id);
        }




    }

    @Override
    public Member addMember(Member newMember) {
        if (newMember.getAddress() == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }

        Address address;
        if (newMember.getAddress().getId() != 0) {
            address = addressRepository.findById(newMember.getAddress().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Address", "id", newMember.getAddress().getId()));
        } else {
            address = addressRepository.save(newMember.getAddress());
        }

        newMember.setAddress(address);

        return memberRepository.save(newMember);
    }
   @Override
    public Member updateMember(long id, Member member) {

        Member existingMember = memberRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));


       existingMember.setFirstName(member.getFirstName());
       existingMember.setLastName(member.getLastName());
       existingMember.setEmail(member.getEmail());
       existingMember.setPhone(member.getPhone());
       existingMember.setDateOfBirth(member.getDateOfBirth());

       if (member.getAddress() != null) {
           existingMember.setAddress(member.getAddress());
       }

       return memberRepository.save(existingMember);


    }



    @Override

    public void  deleteMember(long id) {


       Optional<Member> existingMember = memberRepository.findById(id);
        if (existingMember.isPresent()) {
            memberRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Member", "id", id);
        }

    }

}
