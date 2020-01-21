// 람다(lambda) 문법 - 리턴 값이 있는 메서드
package com.eomcs.oop.ex12;

public class Exam0150 {

  static interface Calculator {
    int compute(int a, int b);
  }

  public static void main(String[] args) {

    Calculator c1 = (int a, int b) -> {
      return a + b;
    };
    System.out.println(c1.compute(200, 100));

    // 1) 리턴 값은 return 명령을 사용하여 처리한다.
    c1 = (a, b) -> {
      return a + b;
    };
    System.out.println(c1.compute(200, 100));

    // 2) 한 문장으로 된 표현식(=값을 리턴하는 한 문장의 코드)인 경우
    // 괄호를 생략할 수 있다.
    c1 = (a, b) -> a + b;
    System.out.println(c1.compute(200, 100));

    // Math.max()는 int 값을 리턴한다. 그래서 이 메서드를 호출하는 문장은 표현식 이다.
    c1 = (a, b) -> Math.max(a, b);
    System.out.println(c1.compute(10, 20));

    // 리턴 값이 있는 경우 중괄호를 생략할 때 return 키워드도 함께 생략해야 한다.
    // c1 = (a, b) -> return a + b; // 컴파일 오류!!
    // System.out.println(c1.compute(200, 100));

    // 리턴 값이 있는 경우 반드시 표현식(expression)이 와야한다.
    // 표현식? 실행한 후 결과가 리턴되는 명령
    // c1 = (a, b) -> System.out.println("Hello");
    // System.out.println(c1.compute(200, 100));
  }


}


