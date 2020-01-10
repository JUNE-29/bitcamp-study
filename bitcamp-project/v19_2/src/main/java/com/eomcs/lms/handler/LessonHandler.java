package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.ArrayList;

public class LessonHandler {

  ArrayList<Lesson> lessonList;
  
  Scanner input;
  
  public LessonHandler(Scanner input) {
    this.input = input;
    this.lessonList = new ArrayList<>();
  }

  public LessonHandler(Scanner input,int capacity) {
    this.input = input;
    lessonList = new ArrayList<>(capacity);
  }
  
  public void listLesson() {
    // 수업 객체 목록을 복사 받을 배열을 준비하고 toArray()를 실행한다.
    // toArray()의 리턴 값은 파라미터로 넘겨준 배열의 주소이다.
    Lesson[] arr = this.lessonList.toArray(new Lesson[this.lessonList.size()]);
    for (Lesson l : arr) {
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
  
  
  public void detailLesson() {
    System.out.print("수업 번호? ");
    int no = input.nextInt();
    input.nextLine(); //숫자 뒤의 남은 공백 제거
    
    int index = indexOfBoard(no);
    
    
    if (index == -1) {
      System.out.println("수업 번호가 유효하지 않습니다.");
      return;
    }
    
    Lesson lesson = this.lessonList.get(index);
    System.out.printf("번호: %d\n", lesson.getNo());
    System.out.printf("수업명: %s\n", lesson.getTitle());
    System.out.printf("수업내용: %s\n", lesson.getDescription());
    System.out.printf("기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
    System.out.printf("총수업시간: %s\n", lesson.getTotalHours());
    System.out.printf("일수업시간: %s\n", lesson.getDayHours());
    
  }
  
  public void updateLesson() {
    System.out.print("수업 번호? ");
    int no = input.nextInt();
    input.nextLine(); //숫자 뒤의 남은 공백 제거
    
    int index = indexOfBoard(no);
    
    if (index == -1) {
      System.out.println("수업 번호가 유효하지 않습니다.");
      return;
    }
    
    boolean changed = false;
    
    String inputStr = null;
    
    Lesson newLesson = new Lesson();
    
    Lesson oldLesson = this.lessonList.get(index);
    
    newLesson.setNo(oldLesson.getNo());
    
    System.out.printf("수업명(%s)? ", oldLesson.getTitle());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newLesson.setTitle(oldLesson.getTitle());
    } else {
      newLesson.setTitle(inputStr);
      changed = true;
    }
    
    System.out.print("설명? ");
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newLesson.setDescription(oldLesson.getDescription());
    } else {
      newLesson.setDescription(inputStr);
      changed = true;
    }

    System.out.printf("시작일(%s)? ", oldLesson.getStartDate());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newLesson.setStartDate(oldLesson.getStartDate());
    }  else {
      newLesson.setStartDate(Date.valueOf(inputStr));
      changed = true;
    }

    System.out.printf("종료일(%s)? ", oldLesson.getEndDate());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newLesson.setEndDate(oldLesson.getEndDate());
    }  else {
      newLesson.setEndDate(Date.valueOf(inputStr));
      changed = true;
    }

    System.out.printf("총 수업시간(%d)? ", oldLesson.getTotalHours());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newLesson.setTotalHours(oldLesson.getTotalHours());
    }  else {
      newLesson.setTotalHours(Integer.parseInt(inputStr));
      changed = true;
    }

    System.out.printf("일 수업시간(%d)? ", oldLesson.getDayHours());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newLesson.setDayHours(oldLesson.getDayHours());
    }  else {
      newLesson.setDayHours(Integer.parseInt(inputStr));
      changed = true;
    }
    
    if (changed) {
      this.lessonList.set(index, newLesson);
      System.out.println("수업을 변경했습니다.");
    } else {
      System.out.println("수업을 변경을 취소했습니다.");
    }
    
    
  }
  
  public void deleteLesson() {
    System.out.print("수업 번호? ");
    int no = input.nextInt();
    input.nextLine(); //숫자 뒤의 남은 공백 제거
    
    int index = indexOfBoard(no);
    
    if (index == -1) {
      System.out.println("수업 번호가 유효하지 않습니다.");
      return;
    }
    
    this.lessonList.remove(index);
    
    System.out.println("수업을 삭제했습니다.");
    
  }
  
  private int indexOfBoard(int no) {
    for(int i = 0; i < this.lessonList.size(); i++) {
      if(this.lessonList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}

