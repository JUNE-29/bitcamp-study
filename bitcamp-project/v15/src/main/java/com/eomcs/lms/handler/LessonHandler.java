package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonHandler {

  Lesson[] lessons;
  int lessonsCount = 0;

  public Scanner input;
  
  static final int LESSON_SIZE = 100;
  
  public LessonHandler(Scanner input) {
    this.input = input;
    this.lessons = new Lesson[LESSON_SIZE];
  }

  public void listLesson() {
    for (int i = 0; i < this.lessonsCount; i++) {
      Lesson l = this.lessons[i];
      System.out.printf("%d, %s, %s ~ %s, %d\n",
          l.getNo(), l.getTitle(), l.getStartDate(), 
          l.getEndDate(), l.getTotalHours());
    }
  }
  
  public void addLesson() {
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.setNo(input.nextInt());

    input.nextLine();

    System.out.print("수업명? ");
    lesson.setTitle(input.nextLine());

    System.out.print("설명? ");
    lesson.setDescription(input.nextLine());

    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(input.next()));

    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(input.next()));

    System.out.print("총 수업시간? ");
    lesson.setTotalHours(input.nextInt());

    input.nextLine();

    System.out.print("일 수업시간? ");
    lesson.setDayHours(input.nextInt());

    input.nextLine();

    this.lessons[this.lessonsCount++] = lesson;
    System.out.println("저장하였습니다.");
  }
}
