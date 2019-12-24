package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;

public class LessonHandler {

  // 인스턴스 필드 (non-static 논스태틱 필드)
  // => 각 수업 목록을 개별적으로 관리
  Lesson[] lessons = new Lesson[LESSON_SIZE];
  int lessonsCount = 0;

  // 클래스 필드 (static field 스태틱필드)
  // => 공유할 변수
  public static Scanner keyboard;
  public static final int LESSON_SIZE = 100;

  public static void listLesson(LessonHandler lessonHandler) {
    for (int i = 0; i < lessonHandler.lessonsCount; i++) {
      Lesson l = lessonHandler.lessons[i];
      System.out.printf("%d, %s, %s ~ %s, %d\n",
          l.no, l.title, l.startDate, 
          l.endDate, l.totalHours);
    }
  }
  
  public static void addLesson(LessonHandler lessonHandler) {
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.no = keyboard.nextInt();

    keyboard.nextLine();

    System.out.print("수업명? ");
    lesson.title = keyboard.nextLine();

    System.out.print("설명? ");
    lesson.description = keyboard.nextLine();

    System.out.print("시작일? ");
    lesson.startDate = Date.valueOf(keyboard.next());

    System.out.print("종료일? ");
    lesson.endDate = Date.valueOf(keyboard.next());

    System.out.print("총 수업시간? ");
    lesson.totalHours = keyboard.nextInt();

    keyboard.nextLine();

    System.out.print("일 수업시간? ");
    lesson.dayHours = keyboard.nextInt();

    keyboard.nextLine();

    lessonHandler.lessons[lessonHandler.lessonsCount++] = lesson;
    System.out.println("저장하였습니다.");
  }
  /*
  public static void detailLesson(LessonHandler lessonHandler) {
    System.out.print("게시물 번호? ");
    int no = keyboard.nextInt();
    keyboard.nextLine();//숫자 뒤의 남은 공백 제거

    Lesson lesson = null;
    for (int i = 0; i < lessonHandler.lessonsCount; i++) {
      if (lessonHandler.lessons[i].no == no) {
        lesson = lessonHandler.lessons[i];
        break;
      }
    }

    if (lesson == null) {
      System.out.println("게시물 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("번호: %d\n", lesson.no);
    System.out.printf("제목: %s\n", lesson.title);
    System.out.printf("등록일: %s\n", lesson.date);
    System.out.printf("조회수: %d\n", lesson.viewCount);

  }*/

}
