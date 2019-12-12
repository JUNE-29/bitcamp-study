package com.myproject.lms;

import java.util.Scanner;

public class App2 {
  public static void main(String[] args){
    
    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("카테고리? ");
    String categories = keyboard.next();
    
    System.out.print("국가별(언어)? ");
    String language = keyboard.next();
    
    System.out.print("나이? ");
    int age = keyboard.nextInt();
    
    System.out.print("MBTI(성격)? ");
    String personality = keyboard.next();
    
    System.out.print("키워드(태그)? ");
    String keyword = keyboard.next();
    
    keyboard.close();
    
    System.out.println("------결과------");
    
    System.out.printf("카테고리 : %s \n", categories);
    System.out.printf("국가별(언어) : %s \n", language);
    System.out.printf("나이 : %d \n", age);
    System.out.printf("MBTI: %s \n", personality);
    System.out.printf("키워드(태그) : # %s  \n", keyword);
    
    /*카테고리 : 인문
          국가별(언어) : 한국
          나이: 28
     MBTI(성격) : INFP
          키워드(태그) : 철학,인생*/
    
    
  }

}
