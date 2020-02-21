package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonAddServlet implements Servlet {

  LessonDao lessonDao;

  public LessonAddServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    Lesson lesson = new Lesson();

    out.println("수업명? ");
    out.println("!{}!");
    out.flush();
    lesson.setTitle(in.nextLine());

    out.println("설명? ");
    out.println("!{}!");
    out.flush();
    lesson.setDescription(in.nextLine());

    out.println("시작일? ");
    out.println("!{}!");
    out.flush();
    lesson.setStartDate(Date.valueOf(in.nextLine()));

    out.println("종료일? ");
    out.println("!{}!");
    out.flush();
    lesson.setEndDate(Date.valueOf(in.nextLine()));

    out.println("총 수업시간? ");
    out.println("!{}!");
    out.flush();
    lesson.setTotalHours(Integer.parseInt(in.nextLine()));

    out.println("일 수업시간? ");
    out.println("!{}!");
    out.flush();
    lesson.setDayHours(Integer.parseInt(in.nextLine()));

    if (lessonDao.insert(lesson) > 0) {
      out.println("새 수업을 등록했습니다."); // 잘 저장했다고 클라이언트에게 응답

    } else {
      out.println("수업 등록에 실패했습니다.");
    }
  }
}
