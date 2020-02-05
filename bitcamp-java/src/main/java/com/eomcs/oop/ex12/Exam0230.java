// 람다(lambda) 문법 - functional interface의 자격
package com.eomcs.oop.ex12;

public class Exam0230 {

  // 추상 메서드가 두개 이상이면 람다 문법으로 구현할 수 없다.
  static interface Player {
    void play();

    void stop();
  }



  public static void main(String[] args) {
    // 추상 메서드가 두 개 이상인 경우 람다 문법을 사용할 수 없다.
    // 추상 메서드가 한 개 라면 가능!
    Player p1 = () -> System.out.println("Hello"); // 컴파일 오류!

    p1.play();

  }
}

