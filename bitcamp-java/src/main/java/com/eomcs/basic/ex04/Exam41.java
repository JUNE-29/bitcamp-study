 package com.eomcs.basic.ex04;

 public class Exam41{
   public static void main(String[] args){
    // 문자 변수
    short s;
    char c;

    s = -32768;
    s = 32767;

    c = 0;
    c = 65535; // 양수만 가능

    char c1 = 65;
    char c2 = 0x41;
    char c3 = 0b0100_0001;
    char c4 = 'A'; 

    // a라는 문자에 정의된 숫자를 저장하는 것. 문자에 부여된 문자의 유니코드, 문자코드, UCS-2 문자 코드, 2바이트 코드 값을 저장하는거다.
    // 문자를 저장하는게 아니고! 코드 값을 저장! // 그래서 정수 변수에도 사용 가능

    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
    System.out.println(c4);
    // 문자코드 임을 인식해서 문자가 출력되는 거임. println 은 무슨 코드 인지 확인 하고 출력. int로 바꾸면 65 출력

    int i1 = 'A';
    i1 = i1 + 10;
    System.out.println(i1);
    System.out.println((char)i1);

    for (int i = 65; i < 'A' + 26; i++){
      System.out.print((char)i);
    }


   }
 }

