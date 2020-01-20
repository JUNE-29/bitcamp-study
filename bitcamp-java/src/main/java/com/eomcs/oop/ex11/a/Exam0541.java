// anonymous class - 익명 클래스가 놓이는 장소: 파라미터 + lambda 문법
package com.eomcs.oop.ex11.a;

public class Exam0541 {
  // 인터페이스 경우 static으로 선언하지 않아도 스태틱 멤버에서 사용할 수 있다.
  interface A {
    void print();
  }

  public static void main(final String[] args) {
    final Exam0541 r = new Exam0541();
    r.m1(() -> System.out.println("안녕!"));
  }

  void m1(final A obj) {
    obj.print();
  }
}
