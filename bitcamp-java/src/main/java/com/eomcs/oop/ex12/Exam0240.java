// 람다(lambda) 문법 - functional interface의 자격
package com.eomcs.oop.ex12;

public class Exam0240 {

  static abstract class Player {
    public abstract void play();
  }

  public static void main(String[] args) {
    // 인터페이스가 아닌 추상 클래스는 람다 구현의 대상이 아니다!
    Player p1 = () -> {
      System.out.println("Hello"); // 컴파일 오류!
    };
    p1.play();
  }
}


