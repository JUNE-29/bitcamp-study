package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonDeleteServlet implements Servlet {

  List<Lesson> lessons;

  public LessonDeleteServlet(List<Lesson> lessons) {
    this.lessons = lessons;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {

    int no = in.readInt();

    int index = -1;
    for (int i = 0; i < lessons.size(); i++) {
      if (lessons.get(i).getNo() == no) {
        // 게시물 번호가 사용자가 보낸 번호와 같다면
        index = i;
        break;
      }
    }

    if (index != -1) { // 삭제하려는 번호의 게시물을 찾았다면
      lessons.remove(index); // 삭제
      out.writeUTF("OK");

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 번호의 게시물이 없습니다.");
    }
  }
}
