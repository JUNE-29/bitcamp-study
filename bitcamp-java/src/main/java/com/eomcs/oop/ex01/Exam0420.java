package com.eomcs.oop.ex01;

//# 클래스 사용 - 사용 범위
//

// 패키지 멤버 클래스
// => 패키지에 직접 소속된 클래스이다.
// => 다른 클래스들도 A 클래스를 사용할 수 있다.
// => bin/main/com/eomcs/oop/ex01/A.class
//     -> Exam0420에 소속되어 있지 않아 따로 클래스가 있음.
class A {}


public class Exam0420 {

  // 중첩 클래스(nested class)
  // => 다른 클래스 안에 정의된 클래스
  // => 그 클래스 안에서만 사용된다. 그 클래스에 소속되어 있다.
  // => bin/main/com/eomcs/oop/ex01/Exam0420$B.class
  //    -> Exam0420.class 밑에 있다. 중첩클래스는 $가 있다.
  class B {}

  public static void main(String[] args) {
    // 로컬 클래스(local class)
    // => 메서드 블록 안에 정의된 클래스
    // => 오로지 그 메서드 블록 안에서만 사용된다. 다른 메서드블록 안에서는 사용 안된다.
    // => 중첩클래스(nested class) 이기도 하다!
    // => bin/main/com/eomcs/oop/ex01/Exam0420$1C.class
    //    -> Exam0420.class 밑에 있다. 숫자가 오면 메소드 안에 소속된 클래스이다.
    class C {}
  }

  public void m1() {
    A ref1;
    B ref2;
    //C ref3; // 컴파일 오류!
  }
}