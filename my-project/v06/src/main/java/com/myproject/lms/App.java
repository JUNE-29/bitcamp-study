package com.myproject.lms;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    
    int[] no = new int [100];
    String[] title = new String[100];
    String[] author = new String[100];
    String[] publisher = new String[100];
    String[] categories = new String[100];
    String[] publishedDate = new String[100];
    String response;
    
    for (int i = 0; i < 3; i++) {
      System.out.print("번호? ");
      no[i] = keyboard.nextInt();
      keyboard.nextLine();
      
      System.out.print("도서명? ");
      title[i] = keyboard.nextLine();
      
      System.out.print("지은이? ");
      author[i] = keyboard.nextLine();
      
      System.out.print("출판사? ");
      publisher[i] = keyboard.nextLine();
      
      System.out.print("카테고리? ");
      categories[i] = keyboard.nextLine();
      
      System.out.print("출판 년도? ");
      publishedDate[i] = keyboard.nextLine();
      
      System.out.println();
      
      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      } 
    }
     
    keyboard.close();
    
    System.out.println();
    
    for(int i = 0; i < 3; i++) {
      System.out.printf("%d, %s, %s, %s, %s, %s\n",
          no[i], title[i], author[i], publisher[i], categories[i], publishedDate[i]);
    }
  }
}
