package com.myproject.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("제목? ");
    String title = keyboard.nextLine();
    
    System.out.print("도서명? ");
    String bookTitle = keyboard.nextLine();
    
    System.out.print("내용? ");
    String contents = keyboard.nextLine();
    
    System.out.print("이미지? ");
    String photo = keyboard.nextLine();
    
    System.out.print("점수?(5점만점) ");
    float score = keyboard.nextFloat();
    
    
    Date dateCreated = new Date(System.currentTimeMillis());
    
    keyboard.close();
    
    System.out.println("--------------------- ");
    
    
    System.out.printf("제목: %s\n", title);
    System.out.printf("도서명: %s\n", bookTitle);
    System.out.printf("내용: %s\n", contents);
    System.out.printf("이미지: %s\n", photo);
    System.out.printf("책에 대한 점수: %1.1f점 / 5점 \n", score);
    System.out.printf("작성일: %s\n", dateCreated);
    
    
    /*제목: 어떻게 살지 알았다
    도서명: 어떻게 살 것인가
    내용: 보니까 어떻게 살지 감잡음
    이미지: bookreview.png
    작성일: 2019-12-12 오늘날짜
    책에 대한 점수(5점만점): 4.5 점*/
    
  }
}
