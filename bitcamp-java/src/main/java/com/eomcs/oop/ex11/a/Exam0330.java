// local class - 스태틱 멤버의 선언된 로컬 클래스
package com.eomcs.oop.ex11.a;

public class Exam0330 {


  public static void main(final String[] args) {
    // 스태틱 멤버는 인스턴스 없이 사용할 수 있다.
    // => 즉 다음과 같이 sm()을 호출할 때 Exam0330 객체없이 호출한다면
    // sm() 메서드 안에서는 절대로 Exam0330 객체를 사용할 수 없는 것이다.
    // => 그래서 스태틱 메서드 안에 있는 로컬 클래스에서는
    // 바깥 클래스의 객체를 사용할 수 없다.
    Exam0330.sm();
  }

  // 스태틱 메서드의 로컬 클래스 사용법
  static void sm() {
    class A {

      // 스태틱 메서드에서는 바깥 클래스의 인스턴스 주소를 알 수 없기때문에
      // 스태틱 메서드 안에 로컬 클래스를 정의하는 경우
      // 컴파일러는 바깥 클래스의 인스턴스 주소를 저장할 필드를 만들지 않는다.
      // 또한 바깥 클래스의 인스턴스 주소를 받는 생성자를 만들지 않는다.
      // => Exam0330$1A.class 파일의 바이트 코드를 확인해보라!

      void m1() {
        // 로컬 클래스가 스태틱 멤버에 정의된 경우
        // 바깥 클래스의 인스턴스를 모르기 때문에
        // 바깥 클래스의 인스턴스 멤버를 사용할 수 없다.
        // => 한마디로 표현하면 컴파일러가 바깥 클래스의 인스턴스 주소를 담을
        // 필드르 만들지 않았기 때문에 사용할 수 없다.
        //
        // Exam0330.this.iValue = 100; // 컴파일 오류!
      }
    }

    final A obj = new A();
    obj.m1();

  }

  int iValue;
}
