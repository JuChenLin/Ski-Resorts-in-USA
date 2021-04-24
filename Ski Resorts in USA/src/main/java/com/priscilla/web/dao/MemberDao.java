//package com.priscilla.web.dao;
//
//import com.priscilla.web.entity.user.Member;
//import org.springframework.stereotype.Repository;
//import org.springframework.validation.annotation.Validated;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//@Repository
//@Validated
//public class MemberDao {
//
//    private static Map<String, Member> members = null;
//
//    static{
//        members = new HashMap<String, Member>();
//
////        members.put("adm0000001", new Member("aa@mail.com", "AAA"));
////        members.put("mem0000001", new Member("bb@mail.com", "BBB"));
////        members.put("mem0000002", new Member("cc@mail.com", "CCC"));
////        members.put("mem0000003", new Member("dd@mail.com", "DDD"));
////        members.put("mem0000004", new Member("ee@mail.com", "EEE"));u
//    }
//
//    // Get all members
//    public Collection<Member> getAll(){
//        return members.values();
//    }
//
//    // Get a member by ID
//    public Member get(Integer id){
//        return members.get(id);
//    }
//
//    // Add/Save a member
//    public void save(Member member){
//        members.put(member.getId(), member);
//    }
//
//    // Delete a member
//    public void delete(Integer id){
//        members.remove(id);
//    }
//}
