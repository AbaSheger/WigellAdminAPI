package org.example.wigelladminapi.services;

import org.example.wigelladminapi.model.Member;

import java.util.List;

public interface MemberInterface {

    List<Member> getAllMembers();
    Member getMemberById(long id);

    Member updateMember(long id, Member member);

    Member addMember(Member member);

    void deleteMember(long id);

}
