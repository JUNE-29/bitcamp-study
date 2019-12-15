package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    
    // 키보드에서 사용자가 입력한 값을 읽어 문자열이나 정수, 부동소수점 등으로 리턴.
    Scanner keyboard = new Scanner(System.in);
    int[] no = new int[100];
    String[] title = new String[100];
    String[] contents = new String[100];
    int[] totalHours = new int[100];
    int[] dayHours  = new int[100];
    Date[] date = new Date[100];
    Date[] endDate = new Date[100];
    String response;
    
    System.out.print("번호? ");
    no[0] = keyboard.nextInt();
    keyboard.nextLine(); //줄바꿈 기호 제거용
    
    System.out.print("수업명? ");
    title[0] = keyboard.nextLine();
    
    System.out.print("수업내용? ");
    contents[0] = keyboard.nextLine();
    
    System.out.print("시작일? ");
    date[0] = Date.valueOf(keyboard.next());
    
    System.out.print("종료일? ");
    endDate[0] = Date.valueOf(keyboard.next());
    
    System.out.print("총 수업시간? ");
    totalHours[0] = keyboard.nextInt();
    keyboard.nextLine(); //줄바꿈
    
    System.out.print("일 수업시간? ");
    dayHours[0] = keyboard.nextInt();
    keyboard.nextLine(); //줄바꿈
    
    
    System.out.println();
    
    System.out.print("계속 입력하시겠습니까?(Y/n) ");
    response = keyboard.nextLine();
    
    if (response.equalsIgnoreCase("y")) {
      System.out.print("번호? ");
      no[1] = keyboard.nextInt();
      keyboard.nextLine(); // 줄바꿈
      
      System.out.print("수업명? ");
      title[1] = keyboard.nextLine();
      
      System.out.print("수업내용? ");
      contents[1] = keyboard.nextLine();
      
      System.out.print("시작일? ");
      date[1] = Date.valueOf(keyboard.next());
      
      System.out.print("종료일? ");
      endDate[1] = Date.valueOf(keyboard.next());
      
      System.out.print("총 수업시간? ");
      totalHours[1] = keyboard.nextInt();
      keyboard.nextLine(); //줄바꿈
      
      System.out.print("일 수업시간? ");
      dayHours[1] = keyboard.nextInt();
      keyboard.nextLine(); //줄바꿈
      
      
      System.out.println();
      
      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      response = keyboard.nextLine();
      
      System.out.println();
      
      if (response.equalsIgnoreCase("y")) {
        System.out.print("번호? ");
        no[2] = keyboard.nextInt();
        keyboard.nextLine(); // 줄바꿈
        
        System.out.print("수업명? ");
        title[2] = keyboard.nextLine();
        
        System.out.print("수업내용? ");
        contents[2] = keyboard.nextLine();
        
        System.out.print("시작일? ");
        date[2] = Date.valueOf(keyboard.next());
        
        System.out.print("종료일? ");
        endDate[2] = Date.valueOf(keyboard.next());
        
        System.out.print("총 수업시간? ");
        totalHours[2] = keyboard.nextInt();
        keyboard.nextLine(); //줄바꿈
        
        System.out.print("일 수업시간? ");
        dayHours[2] = keyboard.nextInt();
        keyboard.nextLine(); //줄바꿈
        
        System.out.println();
        
        System.out.print("계속 입력하시겠습니까?(Y/n) ");
        response = keyboard.nextLine();
      }
     }
    keyboard.close();
    
    System.out.println();
    
    System.out.printf(" %d, %s, %s ~ %s, %d\n", no[0], title[0], date[0], endDate[0], totalHours[0]);
    System.out.printf(" %d, %s, %s ~ %s, %d\n", no[1], title[1], date[1], endDate[1], totalHours[1]);
    System.out.printf(" %d, %s, %s ~ %s, %d\n", no[2], title[2], date[2], endDate[2], totalHours[2]);
   
  }
}
