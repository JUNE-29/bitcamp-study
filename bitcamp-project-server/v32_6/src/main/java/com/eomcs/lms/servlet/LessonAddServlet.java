package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonAddServlet implements Servlet {

  List<Lesson> lessons;

  public LessonAddServlet(List<Lesson> lessons) {
    this.lessons = lessons;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {

    Lesson lesson = (Lesson) in.readObject(); // 객체를 한번 더 읽는다.

    int i = 0;
    for (; i < lessons.size(); i++) {
      if (lessons.get(i).getNo() == lesson.getNo()) {
        break;
      }
    }

    if (i == lessons.size()) { // 같은 번호의 게시물이 없다면
      lessons.add(lesson); // 새 게시물을 등록한다.
      out.writeUTF("OK"); // 잘 저장했다고 응답

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("같은 번호의 게시물이 있습니다.");

    }
  }
}
