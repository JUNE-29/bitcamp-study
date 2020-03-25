package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.util.RequestMapping;

@Component
public class MemberAddFormServlet {

  @RequestMapping("/member/addForm")
  public void service(Map<String, String> params, PrintStream out) throws Exception {

    // 입력 폼만 보내는 일만 한다

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>회원 추가</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 입력</h1>");
    out.println("<form action='/member/add'>");
    out.println("이름:<br>");
    out.println("<textarea name='name' rows='2' cols='50'></textarea><br>");
    out.println("이메일:<br>");
    out.println("<textarea name='email' rows='2' cols='50'></textarea><br>");
    out.println("암호:<br>");
    out.println("<textarea name='password' rows='2' cols='50'></textarea><br>");
    out.println("사진:<br>");
    out.println("<textarea name='photo' rows='2' cols='50'></textarea><br>");
    out.println("전화:<br>");
    out.println("<textarea name='tel' rows='2' cols='50'></textarea><br>");
    out.println("<button>등록</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");


  }
}
