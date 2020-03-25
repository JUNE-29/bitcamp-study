package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.util.RequestMapping;

@Component
public class LessonAddFormServlet {

  @RequestMapping("/lesson/addForm")
  public void service(Map<String, String> params, PrintStream out) throws Exception {

    // 입력 폼만 보내는 일만 한다

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>강의 등록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의 등록</h1>");
    out.println("<form action='/lesson/add'>");
    out.println("강의명:<br>");
    out.println("<textarea name='title' rows='2' cols='50'></textarea><br>");
    out.println("내용:<br>");
    out.println("<textarea name='description' rows='2' cols='50'></textarea><br>");
    out.println("강의 시작일:<br>");
    out.println("<textarea name='startDate' rows='2' cols='50'></textarea><br>");
    out.println("강의 종료일:<br>");
    out.println("<textarea name='endDate' rows='2' cols='50'></textarea><br>");
    out.println("총 강의시간:<br>");
    out.println("<textarea name='totalHours' rows='2' cols='50'></textarea><br>");
    out.println("일 강의시간:<br>");
    out.println("<textarea name='dayHours' rows='2' cols='50'></textarea><br>");
    out.println("<button>등록</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");


  }
}
