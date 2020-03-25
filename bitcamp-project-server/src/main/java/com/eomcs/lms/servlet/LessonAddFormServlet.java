package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.util.RequestMapping;

@Component
public class LessonAddFormServlet {

  @RequestMapping("/board/addForm")
  public void service(Map<String, String> params, PrintStream out) throws Exception {

    // 입력 폼만 보내는 일만 한다

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>수업 입력</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>수업 입력</h1>");
    out.println("<form action='/lesson/add'>");
    out.println("내용:<br>");
    out.println("<textarea name='title' rows='5' cols='60'></textarea><br>");
    out.println("<button>제출</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");


  }
}
