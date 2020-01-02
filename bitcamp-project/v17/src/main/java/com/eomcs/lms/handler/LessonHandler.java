package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonHandler {

  ArrayList lessonList;
  
  public Scanner input;
  
  public LessonHandler(Scanner input) {
    this.input = input;
    this.lessonList = new ArrayList();
  }

  public LessonHandler(Scanner input,int capacity) {
    this.input = input;
    lessonList = new ArrayList(capacity);
  }
  
  public void listLesson() {
    Object[] arr = this.lessonList.toArray();
    for(Object obj : arr) {
      Lesson l = (Lesson) obj;
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

    this.lessonList.add(lesson);
    
    System.out.println("저장하였습니다.");
  }
}
