package com.eomcs.oop.ex02.study;

public class Test01 {
  public static void main(String[] args) {
    
    Score s = new Score();
    
    s.name = "홍길동";
    s.kor = 100;
    s.eng = 90;
    s.math = 80;
    
    Score s2 = new Score();
    
    s2.name = "홍길동";
    s2.kor = 80;
    s2.eng = 80;
    s2.math = 80;
    
    
    //Score.calculate(s);
    // -> 파라미터로 받는거. 그래서 Score.java에서  public static void calculate() {} 에서
    //    static을 붙이고 파라미터 값이 있어야함.
    // static이 있는 메서드로 받으면 매번 파라미터를 붙여줘야한다.
    // 그래서 매번 번거롭다.
    
    // 인스턴스 메서드로 호출하면 파라미터 없이 쓸 수 있다.
    s.calculate();
    s2.calculate();
    
    System.out.println(s.sum);
    System.out.println(s.aver);
    
    System.out.println(s2.sum);
    System.out.println(s2.aver);
    
    
  }
}
