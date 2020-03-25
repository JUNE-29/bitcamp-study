package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.RequestMapping;

@Component
public class LessonListServlet {

  LessonService lessonService;

  public LessonListServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @RequestMapping("/lesson/list")
  public void service(Map<String, String> params, PrintStream out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>강의 목록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("  <h1>강의 목록</h1>");
    out.println("<a href='/lesson/addForm'>강의 등록</a><br>");
    out.println("  <table border='1'>");
    out.println("  <tr>");
    out.println("    <th>번호</th>");
    out.println("    <th>강의명</th>");
    out.println("    <th>강의 시작일 ~ 강의 종료일</th>");
    out.println("    <th>총 강의시간</th>");
    out.println("  </tr>");

    List<Lesson> lessons = lessonService.list();
    for (Lesson l : lessons) {
      out.printf("<tr>" //
          + "<td>%d</td> " //
          + "<td><a href='/lesson/detail?no=%d'>%s</a></td> " //
          + "<td>%s ~ %s</td> " //
          + "<td>%d</td>" //
          + "</tr>\n", //
          l.getNo(), //
          l.getNo(), //
          l.getTitle(), //
          l.getStartDate(), //
          l.getEndDate(), //
          l.getTotalHours());
    }
    out.println("</body>");
    out.println("</html>");
  }
}
