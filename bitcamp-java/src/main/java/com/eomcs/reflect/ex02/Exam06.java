// 클래스 정보 추출 - 패키지 정보 알아내기
package com.eomcs.reflect.ex02;

public class Exam06 {
  static interface A {
  }
  static interface B {
  }
  static interface C {
  }

  static class D implements A, B, C {
  }

  public static void main(String[] args) throws Exception {
    Class<?> clazz = Class.forName("com.eomcs.reflect.ex02.Exam06$D");
    // 중첩클래스의 바깥클래스의 패키지명까지만 나온다! 바깥클래스까지 아니냐는 착각 하지 말 것!

    // 해당 클래스의 패키지 정보를 가져온다.
    Package p = clazz.getPackage();
    System.out.println(p.getName());
  }

}
