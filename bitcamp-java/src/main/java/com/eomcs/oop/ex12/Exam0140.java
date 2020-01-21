// 람다(lambda) 문법 - 람다 파라미터II
package com.eomcs.oop.ex12;

public class Exam0140 {

  static interface Player {
    void play(String name, int age);
  }

  public static void main(String[] args) {
    // 1) 파라미터는 괄호()안에 선언한다.
    Player p1 = (String name, int age) -> System.out.printf("Hello!, %s(%d)!\n", name, age);
    p1.play("길동쓰", 20);

    // 2) 파라미터 타입을 생략할 수 있다.
    p1 = (name, age) -> System.out.printf("Hello!, %s(%d)!", name, age);
    p1.play("꺽쩡쓰", 20);

    // 파라미터가 여러 개일 때는 괄호를 생략할 수 없다. 한개는 가능!
    // p1 = name, age -> System.out.printf("Hello!, %s(%d)!", name, age); // 오류!
    // p1.play("꺽쩡쓰", 30);

  }
}


