package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

/*# 과제 I
사용자로부터 직삼각형의 밑변 숫자를 입력 받아 '*' 문자로 그려라. 

## 구현 조건
반복문을 사용할 때는 while 또는 do ~ while 문만을 사용하라!

## 실행 결과
```
밑변 길이? 5
*
**
***
****
*****
``` */

public class Test01 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    int no;
    
    System.out.print("밑변 길이? ");
    no = keyScan.nextInt();
    
    System.out.println("------result------");
    
    int count = 1;
    while(count <= no) {
      int count1 = 1;
      while(count1 <= count) {
        System.out.print("*");
        count1++;
      }
      System.out.println();
      count++;
    }
    
 
    
    keyScan.close();
  }

}
