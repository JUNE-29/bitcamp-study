// 람다(lambda) 문법 - 람다 파라미터 I
package com.eomcs.oop.ex12;

public class Exam0130 {

  static interface Player {
    void play(String name);
  }

  public static void main(String[] args) {
    // 1) 파라미터 괄호() 안에 선언한다.
    Player p1 = (String name) -> System.out.println("Hello!," + name + "!");
    p1.play("길동쓰");

    // 2) 파라미터 타입을 생략할 수 있다
    p1 = (name) -> System.out.println("Hello!," + name + "!");
    p1.play("꺽쩡쓰");

    Player p2 = (name) -> System.out.println("Hello!," + name + "!");
    p2.play("꺽쩡쓰");

    // 3) 파라미터가 한 개일 때는 괄호도 생략할 수 있다.
    p1 = name -> System.out.println("Hello!," + name + "!");
    p1.play("관순쓰");

    Player p3 = name -> System.out.println("Hello!," + name + "!");
    p3.play("관순쓰");
  }
}


