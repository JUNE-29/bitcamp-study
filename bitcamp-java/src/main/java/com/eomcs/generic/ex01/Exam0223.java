// 제네릭(Generic) 문법 정리 - 레퍼런스와 인스턴스 생성
package com.eomcs.generic.ex01;

import java.util.ArrayList;
import java.util.HashSet;


public class Exam0223 {


  static class A {}
  static class B1 extends A{}
  static class B2 extends A {}
  static class C extends B1 {}
  /*
   * 
   *   Object
   *     A
   *    / \
   *  B1  B2
   *  |
   *  C
   *  
   */  
  public static void main(String[] args) {
    //m1(ArrayList<A>)
    // => A 타입에 대해서만 ArrayList 객체를 파라미터로 넘길 수 있다.
    // => A의 하위 타입은 불가능
    //
    m1(new ArrayList()); // 컴파일 오류는 아니지만 타입을 지정하지 않는 것은 바람직하지 않다.
    // 왜?
    // => 타입을 지정하지 않으면 ArrayList에 A가 아닌 다른 타입의 객체가 들어갈 수 있다.
    // => 그러면 실행중에 get()을 호출할 때 형변환 문제가 발생할 것이다. 
    //
    //m1(new ArrayList<Object>()); //컴파일 오류 
    m1(new ArrayList<A>()); 
    //m1(new ArrayList<B1>());//컴파일 오류 
    //m1(new ArrayList<B2>());//컴파일 오류 
    //m1(new ArrayList<C>());//컴파일 오류 
  }
  
  static void m1(ArrayList<A> list) {
    // A와 A타입(자식)들을 담는 바구니 준비. A타입만 다룰 수 있다. 상위도 안됨

  }
}








