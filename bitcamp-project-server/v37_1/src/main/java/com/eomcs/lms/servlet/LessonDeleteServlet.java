package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.LessonDao;

public class LessonDeleteServlet implements Servlet {

  LessonDao lessonDao;

  public LessonDeleteServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }


  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {

    int no = in.readInt();

    if (lessonDao.delete(no) > 0) {
      out.writeUTF("OK");

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 번호의 게시물이 없습니다.");
    }
  }
}
