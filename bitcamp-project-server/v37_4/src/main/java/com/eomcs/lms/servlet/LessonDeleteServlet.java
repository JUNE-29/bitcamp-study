package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;

public class LessonDeleteServlet implements Servlet {

  LessonDao lessonDao;

  public LessonDeleteServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }


  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    out.println("번호? "); // 사용자에게 출력하라!
    out.println("!{}!"); // 사용자로부터 한줄의 문자열을 입력 받아서 보내라! 라는 규칙!
    out.flush();

    int no = Integer.parseInt(in.nextLine());

    if (lessonDao.delete(no) > 0) {
      out.println("수업을 삭제했습니다.");

    } else {
      out.println("해당 번호의 수업이 없습니다.");
    }
  }
}
