package com.myproject.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args){

    Scanner keyboard = new Scanner(System.in);
    
    int[] no = new int[100];
    String[] categories = new String[100];
    String[] language = new String[100];
    int[] age = new int[100];
    String[] mbti = new String[100];
    String[] keyword = new String[100];
    Date[] date = new Date[100];
    String response;
    
    for(int i = 0; i < 3; i++) {
      System.out.print("번호? ");
      no[i] = keyboard.nextInt();
      keyboard.nextLine();
      
      System.out.print("카테고리? ");
      categories[i] = keyboard.nextLine();
      
      System.out.print("언어? ");
      language[i] = keyboard.nextLine();
      
      System.out.print("나이? ");
      age[i] = keyboard.nextInt();
      keyboard.nextLine();
      
      System.out.print("성격(mbti)? ");
      mbti[i] = keyboard.nextLine();
      
      System.out.print("키워드? ");
      keyword[i] = keyboard.nextLine();
      
      date[i] = new Date(System.currentTimeMillis());
      
      System.out.println();
      
      System.out.print("계속 입력하시겠습니까?(Y/n)");
      response =  keyboard.nextLine();
      if(!response.equalsIgnoreCase("y")) {
        break;
    } 
   }  
    keyboard.close();
    
    System.out.println();
    
    for(int i = 0;  i < 3; i++) {
      System.out.printf("%d, %s, %d, %s, # %s, %s\n",
          no[i], categories[i], age[i], mbti[i], keyword[i], date[i]);
    }
  }
}
