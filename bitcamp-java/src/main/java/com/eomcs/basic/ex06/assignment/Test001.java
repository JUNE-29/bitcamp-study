package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class Test001 {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    
    
    System.out.print("밑변길이? ");
    int width = keyScan.nextInt();
    
    int line = 1;
    while(line <= width) {
      int x = 1;
      while(x <= line) {
        System.out.print("*");
         x++;
      }
      System.out.println();
      line++;
    }
    
    System.out.println();
    
  }
}
