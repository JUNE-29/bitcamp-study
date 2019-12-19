package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    
    // 키보드에서 사용자가 입력한 값을 읽어 문자열이나 정수, 부동소수점 등으로 리턴.
    Scanner keyboard = new Scanner(System.in);

    final int SIZE = 100;
    int[] no = new int[SIZE];
    String[] title = new String[SIZE];
    String[] description = new String[SIZE];
    Date[] startDate = new Date[SIZE];
    Date[] endDate = new Date[SIZE];
    int[] totalHours = new int[SIZE];
    int[] dayHours = new int[SIZE];

    int count = 0;
    
    for(int i = 0; i< SIZE; i++) {
      count++;

      System.out.print("번호? ");
      no[i] = keyboard.nextInt();
      
      keyboard.nextLine(); //줄바꿈 기호 제거용

      System.out.print("수업명? ");
      title[i] = keyboard.nextLine();

      System.out.print("수업내용? ");
      description[i] = keyboard.nextLine();

      System.out.print("시작일? ");
      startDate[i] = Date.valueOf(keyboard.next());

      System.out.print("종료일? ");
      endDate[i] = Date.valueOf(keyboard.next());

      System.out.print("총 수업시간? ");
      totalHours[i] = keyboard.nextInt();
      
      keyboard.nextLine(); //줄바꿈

      System.out.print("일 수업시간? ");
      dayHours[i] = keyboard.nextInt();
      
      keyboard.nextLine(); //일수업시간 입력 값 다음에 남아 있는 줄바꿈 값 제거
      
      System.out.print("계속 입력하시겠습니까?(Y/n)");
      String response = keyboard.nextLine();
      if(!response.equalsIgnoreCase("y")) 
        break;
    }

    System.out.println();
    
    for (int i = 0; i < count; i++) {
      System.out.printf("%d, %s, %s ~ %s, %d\n",
          no[i], title[i], startDate[i], endDate[i], totalHours[i]);
    }
    keyboard.close();

  }
}