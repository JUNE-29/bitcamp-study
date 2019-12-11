package com.eomcs.lms;

import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("번호? ");
    String number = keyboard.nextLine();
    
    System.out.print("내용? ");
    String note = keyboard.nextLine();
    
    System.out.print("작성일? ");
    String date = keyboard.nextLine();
    
    System.out.print("조회수? ");
    String view = keyboard.nextLine();
    
    System.out.println();
    
    
    System.out.printf("번호: %s\n", number);
    System.out.printf("내용: %s\n", note);
    System.out.printf("작성일: %s\n", date);
    System.out.printf("조회수: %s\n", view);
    
    keyboard.close();
    
  }

}
