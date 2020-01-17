// final 사용법: 상수 필드 만들기

package com.eomcs.oop.ex06.e;

public final class Exam0210 {
  // 필드에 final을 붙이면 상수 필드가 된다.
  // 값을 한 번만 저장해야 한다.
  // 필드를 선언할 때 즉시 값을 저장해야 한다.
  //
  final int a = 100;

  public void m1() {
    // 상수는 값을 저장할 수 없다다다다ㅏ다닫다ㅏ
    a = 200; // 컴 파일 오류
  }
}
