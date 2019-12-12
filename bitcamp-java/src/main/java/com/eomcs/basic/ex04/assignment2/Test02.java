// 과제 1 : 가위,바위,보 게임 애플리케이션을 작성하라.
// - 실행1
// 가위,바위,보? 보
// 컴퓨터: 가위  (랜덤 값이 출력된다. 힌트: Math.random())
// => 졌습니다.
//
// - 실행2
// 가위,바위,보? 바위
// 컴퓨터: 가위
// => 이겼습니다.
//
package com.eomcs.basic.ex04.assignment2;

import java.util.Scanner;

public class Test02 {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    int comNumber = (int) (Math.random()*3)+1;
    
    System.out.println("1: 가위, 2: 바위, 3: 보? 번호 선택해주세요");
    int myNumber = keyboard.nextInt();

    keyboard.nextLine();

    if(myNumber == 1){
      System.out.println("나: 가위");
    }else if(myNumber == 2){
      System.out.println("나: 바위");
    }else if(myNumber == 3){
      System.out.println("나: 보");
    }



    System.out.print("컴퓨터: ");
    if(comNumber == 1){
      System.out.println("가위");
    } else if(comNumber == 2){
      System.out.println("바위");
    } else{
      System.out.println("보");
    }

    if(comNumber == myNumber){
      System.out.println(" => 비겼습니다.");
    }else if(comNumber == 1 && myNumber == 2){
      System.out.println(" => 이겼습니다.");
    }else if(comNumber == 2 && myNumber == 3){
      System.out.println(" => 이겼습니다.");
    }else if(comNumber == 3 && myNumber == 1){
      System.out.println(" => 이겼습니다.");
    }else if(comNumber == 1 && myNumber == 3){
      System.out.println(" => 졌습니다.");
    }else if(comNumber == 2 && myNumber == 1){
      System.out.println(" => 졌습니다.");
    }else if(comNumber == 3 && myNumber == 2){
      System.out.println(" => 졌습니다.");
    }else {}

    keyboard.close();


  }
}
