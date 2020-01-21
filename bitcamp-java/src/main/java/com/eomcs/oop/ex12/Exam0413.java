// 리턴 문장에 람다(lambda) 활용
package com.eomcs.oop.ex12;

public class Exam0413 {

  static interface Interest {
    double compute(int money);
  }

  static Interest getInterest(final double rate) {
    // 익명 클래스로 인터페이스 구현한 후 객체 리턴하기
    return new Interest() {
      @Override
      public double compute(int money) {
        return money + (money * rate / 100);
      }
    };
  }


  public static void main(String[] args) {
    Interest i1 = getInterest(1.5);
    System.out.printf("합계: %.1f\n", i1.compute(10_0000_0000));

    Interest i2 = getInterest(2.5);
    System.out.printf("합계: %.1f\n", i2.compute(10_0000_0000));
  }
}


