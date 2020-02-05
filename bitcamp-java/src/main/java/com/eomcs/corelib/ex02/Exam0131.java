// String - mutable vs immutable 객체
package com.eomcs.corelib.ex02;

public class Exam0131 {
  public static void main(String[] args) {
    // StringBuffer 객체는 mutable 객체이다.
    // 인스턴스의 데이터를 변경할 수 있다.
    // 원래의 문자열을 변경하고 싶을 때 사용하는 클래스이다.
    //
    StringBuffer buf = new StringBuffer("Hello");
    buf.replace(2, 4, "xxxx"); // 2 이상 4 미만을 뜻한다.
    System.out.println(buf); // 원본을 바꾼다.

    StringBuffer buf2 = new StringBuffer("ACTION");
    buf2.replace(1, 5, "ctio");
    System.out.println(buf2);
  }
}

