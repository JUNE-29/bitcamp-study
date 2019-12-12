// 과제 1 : 계산기 애플리케이션을 작성하라.
// - 실행
// 값1? 10
// 값2? 20
// 연산자(+,-,*,/)? +
// => 10 + 20 = 30 
//
package com.eomcs.basic.ex04.assignment2;

import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    

    System.out.print("값1? ");
    int value1 = keyboard.nextInt();

    System.out.print("값2? ");
    int value2 = keyboard.nextInt();

    keyboard.nextLine();

    
    System.out.print("연산자(+,-,*,/)? ");
    String input = keyboard.next();
    char d = input.charAt(0);

    if(d == '+'){
        System.out.print( value1 + "+" + value2 + "=" + (value1+value2));
    } else if(d == '-'){
        System.out.print(value1 + "-" + value2 + "=" + (value1 - value2));
    } else if(d == '*'){
        System.out.print(value1 + "*" + value2 + "=" + (value1 * value2));
    } else if(d == '/'){
      System.out.print(value1 + "/" + value2 + "=" + (value1 / value2));
    } else {
      System.out.print("잘못입력했습니다.");
    }

   keyboard.close();




  }
}
