package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.RequestMapping;

@Component
public class MemberDetailServlet {

  MemberService memberService;

  public MemberDetailServlet(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/detail")
  public void service(Map<String, String> params, PrintStream out) throws Exception {
    int no = Integer.parseInt(params.get("no"));

    Member member = memberService.get(no);

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>회원 상세정보</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 상세정보</h1>");

    if (member != null) {
      out.printf("번호: %d<br>\n", member.getNo());
      out.printf("이름: %s<br>\n", member.getName());
      out.printf("이메일: %s<br>\n", member.getEmail());
      out.printf("암호: %s<br>\n", member.getPassword());
      out.printf("사진: %s<br>\n", member.getPhoto());
      out.printf("전화: %s<br>\n", member.getTel());
      out.printf("<p><a href='/member/delete?no=%d'>삭제</a>\n", member.getNo());
      out.printf("<a href='/member/updateForm?no=%d'>변경</a></p>\n", member.getNo());
    } else {
      out.println("<p>해당 번호의 회원이 없습니다.</p>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}
