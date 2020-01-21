package com.eomcs.oop.ex09.g;

public interface A {
  /* public abstract */ void m1();

  default void m2() {}
  // 규칙을 추가하되 기존것들을 깨지지 않게..! 여기서 구현이 되어서 영향을 주지 않는다

  static void m3() {
    System.out.println("오호라~~~ 인터페이스도 스태틱 메서드를 가질 수 있네!");
  }

}
