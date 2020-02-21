package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberAddServlet implements Servlet {

  MemberDao memberDao;

  public MemberAddServlet(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    Member member = new Member();

    out.println("이름? ");
    out.println("!{}!");
    member.setName(in.nextLine());

    out.println("이메일? ");
    out.println("!{}!");
    member.setEmail(in.nextLine());

    out.println("비밀번호? ");
    out.println("!{}!");
    member.setPassword(in.nextLine());

    out.println("사진? ");
    out.println("!{}!");
    member.setPhoto(in.nextLine());

    out.println("전화? ");
    out.println("!{}!");
    member.setTel(in.nextLine());

    member.setRegisteredDate(new Date(System.currentTimeMillis()));

    if (memberDao.insert(member) > 0) { // 같은 번호의 게시물이 없다면
      out.println("새 회원정보를 등록했습니다."); // 잘 저장했다고 클라이언트에게 응답

    } else {
      out.println("회원정보 등록에 실패했습니다.");
    }
  }
}
