package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    
    // 키보드에서 사용자가 입력한 값을 읽어 문자열이나 정수, 부동소수점 등으로 리턴.
    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("번호? "); //print는 옆으로 커서가 생김.
    int no = keyboard.nextInt();
    
    keyboard.nextLine(); //nextInt()후에  남아 있는 줄바꿈 기호를 제거한다.
    
    System.out.print("수업명? ");
    String title = keyboard.nextLine();
    
    System.out.print("설명? ");
    String description = keyboard.nextLine();
    
    System.out.print("시작일? ");
    // "yyyy-MM-dd" 형태로 입력된 문자열을 날짜 정보로 바꾼다.
    Date startDate = Date.valueOf(keyboard.next());
    
    System.out.print("종료일? ");
    Date endDate = Date.valueOf(keyboard.next());
    
    System.out.print("총 수업시간? ");
    int totalHours = keyboard.nextInt();
    
    System.out.print("일수업시간? ");
    int dayHours = keyboard.nextInt();
    
    System.out.println();
    
    /*System.out.println("번호: " + no);
    System.out.println("수업명: " + title);
    System.out.println("설명: " + description);
    System.out.println("기간: " + startDate + "~" + endDate);
    System.out.println("총수업시간: " + totalHours + " 시간");
    System.out.println("일수업시간: " + dayHours + " 시간");*/
    
    System.out.printf("번호: %d\n" , no);
    System.out.printf("수업명: %s\n" , title);
    System.out.printf("설명: %s\n" , description);
    System.out.printf("기간: %s ~ %s\n" , startDate, endDate);
    System.out.printf("총수업시간: %d 시간\n" , totalHours );
    System.out.printf("일수업시간: %d 시간\n" , dayHours );
    
    //\n은 이스케이프 문자. 넥스트 라인으로 바꿔주는 것
    
    keyboard.close();
   
  }
}
