// 사용자 입력을 받는 코드를 별도의 메서드로 분리한다.
//
package com.eomcs.lms.handler;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonDetailCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;

  public Prompt prompt;

  public LessonDetailCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }



  @Override
  public void execute() {

    try {
      int no = prompt.inputInt("번호? ");

      out.writeUTF("/lesson/detail");
      out.writeInt(no);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }


      Lesson lesson = (Lesson) in.readObject();
      System.out.printf("번호: %d\n", lesson.getNo());
      System.out.printf("수업명: %s\n", lesson.getTitle());
      System.out.printf("수업내용: %s\n", lesson.getDescription());
      System.out.printf("기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
      System.out.printf("총수업시간: %s\n", lesson.getTotalHours());
      System.out.printf("일수업시간: %s\n", lesson.getDayHours());

    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }

  }
}


