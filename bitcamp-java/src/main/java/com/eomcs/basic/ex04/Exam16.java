 package com.eomcs.basic.ex04;

 public class Exam16 {
   public static void main(String[] args){
      // 변수의 종류
      // => primitive data type (자바 원시 데이터 타입)
      byte b; // 1바이트 크기를 갖는 메모리
      short s; // 2 바이트
      int i; // 4 바이트
      long l; // 8 바이트

      float f; // 4 바이트
      double d; // 8 바이트

      boolean bool; // jvm 에서 4바이트로 다룬다. int 로 취급한다.

      char c; // 2 바이트

      // => reference : 다른 메모리의 주소를 저장하는 변수
      String str; // 문자열에 있는 메모리의 주소를 저장
      Thread t; // 쓰레드 정보. 쓰레드에 있는 메모리의 주소를 저장
      java.sql.Date date; // 날짜가 있는 메모리의 주소를 저장
      java.net.Socket socket; // 네트워크 정보를 저장하고 있는 그 메모리의 주소.

      // 아파트 a;
      // 공장 b;
      // 사무실 c; 
      // 차고 d; 이런 것 처럼 주소를 저장하는 것 

   }
 }
