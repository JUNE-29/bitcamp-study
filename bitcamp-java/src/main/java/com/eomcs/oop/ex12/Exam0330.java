// 아규먼트에 람다(lambda) 활용 III - 여러 개의 문장이 있는 경우
package com.eomcs.oop.ex12;

public class Exam0330 {

  static interface Calculator {
    int compute(int start, int end);
  }

  static void test(Calculator c) {
    System.out.printf("결과: %d\n", c.compute(1, 10));
  }


  public static void main(String[] args) {
    // 여러 문장을 실행하는 경우 블록 {}으로 감싸라!
    // 여기서 바로 실행되는것이 아니고
    // 이런 작업을 할 객체를 정의한다음에 Calculator에 담아서 test에게 주고
    // test 내부에서 작업을 한 뒤 호출해 줄 것이다.
    test((a, b) -> {
      int sum = 0;
      for (int i = a; i <= b; i++) {
        sum += i;
      }
      return sum;
    });

  }
}


