package com.eomcs.lms.service;

import java.util.List;
import com.eomcs.lms.domain.Member;

public interface MemberService {

  int add(Member member) throws Exception;

  List<Member> list() throws Exception;

  Member get(int no) throws Exception;

  public int update(Member member) throws Exception;

  int delete(int no) throws Exception;

  List<Member> search(String keyword) throws Exception;

  Member get(String email, String password) throws Exception;

}
