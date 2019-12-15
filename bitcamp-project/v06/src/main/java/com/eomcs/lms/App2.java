package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    
    int[] no = new int[100];
    String[] name = new String[100];
    String[] email = new String[100];
    int[] password = new int[100];
    String[] photo = new String[100];
    String[] tel = new String[100];
    String response;
    Date[] date = new Date[100];
    int[] count = new int[100];
    
    for (int i = 0; i < 3; i++) {
      System.out.print("번호? ");
      no[i] = keyboard.nextInt();
      keyboard.nextLine(); // 줄바꿈 
      
      System.out.print("이름? ");
      name[i] = keyboard.nextLine();
      
      System.out.print("이메일? ");
      email[i] = keyboard.nextLine();
      
      System.out.print("비밀번호? ");
      password[i] = keyboard.nextInt();
      keyboard.nextLine(); // 줄바꿈 기호
      
      System.out.print("사진? ");
      photo[i] = keyboard.nextLine();
      
      System.out.print("전화? ");
      tel[i] = keyboard.nextLine();
      
      date[i] = new Date(System.currentTimeMillis());
      count[i] = 0;
      
      System.out.println();
      
      System.out.print("계속 입력하시겠습니까?(Y/n)");
      response = keyboard.nextLine();
      if(!response.equalsIgnoreCase("y")) {
        break;
      }
    }
    
    keyboard.close();  
    System.out.println();
    
    for(int i = 0; i < 3; i++){
      System.out.printf("%d, %s, %s, %s, %s\n", 
          no[i], name[i], email[i], tel[i], date[i]);
    }
    
    
  }

}
