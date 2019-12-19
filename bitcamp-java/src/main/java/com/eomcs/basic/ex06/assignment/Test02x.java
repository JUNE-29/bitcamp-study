package com.eomcs.basic.ex06.assignment;
/*# 과제 II
사용자로부터 마름모의 가로 길이를 숫자를 입력 받아 '*' 문자로 그려라. 단 마름모의 절반만 그린다.
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
 ****
 ***
 **
 *
``` */
import java.util.Scanner;

public class Test02x {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);

    int width;
    System.out.print("밑변길이? ");
    width = keyScan.nextInt();

    int count = 1;
    while(count <= width) {
      int count1 = 1;
      while(count1 <= count) {
        System.out.print("*");
        count1++;
      }
      System.out.println();
      count++;
    }

    count = width -1;
    while(width >= 1) {
      int count1 = 1;
      while(count1 <= count) {
        System.out.print("*");
        count1++;
      }
      System.out.println();
      count--;
    }
    keyScan.close();
  }
}

