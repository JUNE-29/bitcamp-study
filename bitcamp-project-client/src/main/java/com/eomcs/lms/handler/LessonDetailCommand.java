// 사용자 입력을 받는 코드를 별도의 메서드로 분리한다.
//
package com.eomcs.lms.handler;


import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonDetailCommand implements Command {

  LessonDao lessonDao;
  public Prompt prompt;

  public LessonDetailCommand(LessonDao lessonDao, Prompt prompt) {
    this.lessonDao = lessonDao;
    this.prompt = prompt;
  }



  @Override
  public void execute() {

    try {

      int no = prompt.inputInt("번호? ");
      Lesson lesson = lessonDao.findByNo(no);
      System.out.printf("번호: %d\n", lesson.getNo());
      System.out.printf("수업명: %s\n", lesson.getTitle());
      System.out.printf("수업내용: %s\n", lesson.getDescription());
      System.out.printf("기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
      System.out.printf("총수업시간: %s\n", lesson.getTotalHours());
      System.out.printf("일수업시간: %s\n", lesson.getDayHours());

    } catch (Exception e) {
      System.out.println("조회 실패!");
    }

  }
}


