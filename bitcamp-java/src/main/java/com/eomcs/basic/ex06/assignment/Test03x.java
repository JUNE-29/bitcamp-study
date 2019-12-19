package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

/*# 과제 III
사용자로부터 정삼각형 밑변의 길이를 숫자를 입력 받아 '*' 문자로 그려라.
 
## 구현 조건
반복문을 사용할 때는 while 또는 do ~ while 문만을 사용하라!

## 실행 결과
```
밑변 길이? 5
  *
 ***
*****
``` */
public class Test03x {
   public static void main(String[] args) {
     Scanner keyScan = new Scanner(System.in);
     System.out.print("밑변의 길이? ");
     int len = keyScan.nextInt();

     int starLen = 1;
     while (starLen <= len) {
         int spaceCnt = 1;
         int spaceLen = (len - starLen) / 2;
         while (spaceCnt <= spaceLen) {
             System.out.print(" ");
             spaceCnt++;
         }
         
         int starCnt = 1;
         while (starCnt <= starLen) {
             System.out.print("*");
             starCnt++;
         }
         System.out.println();
         starLen += 2;
     }
 }
}

