// final 사용법: 오버라이딩 불가!!!

package com.eomcs.oop.ex06.e;

public class Exam0140 extends Exam0130 {
  // 메서드에 final을 붙이면 서브 클래스에서 오버라이딩 할 수 없다.
  // public void m1() {
  // final 메서드는 오버라이딩 불가!
  // }

  @Override
  public void m2() {
    // final 이 아닌 메서드는 오버라이딩 가능
  }

}
