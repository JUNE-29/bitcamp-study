// 사용자 입력을 받는 코드를 별도의 메서드로 분리한다.
//
package com.eomcs.lms.handler;


import java.util.Iterator;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonListCommand implements Command {

  List<Lesson> lessonList;


  public LessonListCommand(List<Lesson> list) {
    this.lessonList = list;
  }

  @Override
  public void execute() {
    Iterator<Lesson> iterator = lessonList.iterator();
    // Iterator 객체를 통해 LessonList에 보관되어 있는 값을 꺼낸다.
    while (iterator.hasNext()) {
      Lesson l = iterator.next();
      System.out.printf("%d, %s, %s ~ %s, %d\n", l.getNo(), l.getTitle(), l.getStartDate(),
          l.getEndDate(), l.getTotalHours());
    }
  }
}


