package com.eomcs.basic.ex03;

public class Exam1 {
  public static void main(String[] args) {
    //정수 리터럴
    System.out.println(78); //10진수 표기법
    // 78 이 정수 리터럴이다.

    System.out.println(+78);
    System.out.println(-78);

    System.out.println(0116); //8진수 표기법
    System.out.println(-0116); //8진수

    System.out.println(0x4e); //16진수 표기법
    System.out.println(-0x4e); //16진수 표기법

    System.out.println(0x01001110); //2진수 표기법

    // 부동소수점 리터럴
    System.out.println(3.14); // 고정소수점
    System.out.println(0.314e1); // 부동소수점
    System.out.println(31.4e-1); //부동 소수점

    // 논리 리터럴
    System.out.println(true); // 대문자 쓰면 안됨
    System.out.println(false);
    
    // 문자 리터럴
    System.out.println('A');
    System.out.println('가'); // ''는 문자 딱 한글자만 됨 '가나' 안돼

    // 문자열 리터럴
    System.out.println("안녕하세요! 비트캠프!");


  }
}