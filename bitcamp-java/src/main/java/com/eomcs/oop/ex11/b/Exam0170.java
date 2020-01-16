// 클래스의 종류 : 중첩 클래스 요약 정리
package com.eomcs.oop.ex11.b;

// 패키지 멤버 클래스
class A {}

// 패키지 멤버 클래스
public class Exam0170 {

  // static nested class
  static class B {}

  // non-static nested class = inner class
  class C {}

  public static void main(String[] args) throws Exception {

    // local class 
    class D {}

    // anonymous class
    Object obj = new Object() {};
    Object obj2 = new Object() {
      int a; // 인스턴스 필드
      @Override
      public String toString() {
        return "오호라! 익명 클래스";
      }
    };
  
    
    // 배열과 헷갈리지 말기 
    Object[] arr = new Object[] {};
    Object[] arr2 = new Object[] {10, 20, 30};
    
    int[] arr3 = new int[] {};
    int[] arr4 = new int[] {10, 20, 30};
    
  }

}







