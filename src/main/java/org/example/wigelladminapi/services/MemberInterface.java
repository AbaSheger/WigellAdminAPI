package org.example.wigelladminapi.services;

import org.example.wigelladminapi.entities.Member;

import java.util.List;

public interface MemberInterface {

    List<Member> getAllMembers();
    Member getMemberById(long id);

    Member updateMember(long id, Member member);

    Member addMember(Member newMember);

    void deleteMember(long id);

}
