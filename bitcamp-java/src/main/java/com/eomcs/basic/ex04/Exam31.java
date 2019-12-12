 package com.eomcs.basic.ex04;

 public class Exam31 {
   public static void main(String[] args){
      // 부동소수점 변수 - 메모리 크기
      float f;

      f = 3.141592f;
      System.out.println(f);

      f = 3.1415929f;
      System.out.println(f);

      f= 0.0000003141529f;
      System.out.println(f); // 앞에 있는 영은 자릿수로 안친다.

      f= 0.00000031415929f; // 소수점 이하인 경우 앞의 0 제거
      System.out.println(f);

      f= 314159200000.0f; // 소수점 이상인 경우 뒤의 0을 포함해서 유효자릿수 계산
      System.out.println(f);

      double d;
      d = 9.87654321234567;
      System.out.println(d);

      d = 98765432.1234567;
      System.out.println(d);

      d = 98765432123456.7;
      System.out.println(d);

      d = 98765432123456.78;
      System.out.println(d);

      d = 98765432123456.74;  // 값이 왜곡된다.
      System.out.println(d);

      // 변수와 리터럴
      f = 99999.88f;
      System.out.println(f);

      f = 99999.887777f;  // 이미 리터럴이 4바이트 유효자릿수를 넘어갔다. // 리터럴이 7자리를 넘어가면 안된다.
      System.out.println(f);

      d = 99999.88f;   // 4바이트 부동소수점을 2진수로 바뀌어서 double(8바이트)에 넣었을때. 값이 다름!
      System.out.println(d);

      d = 99999.88;  
      System.out.println(d);

      // 4바이트 메모리를 집어넣을때는 4바이트 리터럴을 사용하기 !! 4바이트를 8바이트에 넣었을때 값이 다르게 나온다.
      // 8바이트 메모리를 집어넣을때는 8바이트 리터럴을 사용하기 !!
      // 정수와 다르다. 부동소수점은 예측이 달라진다. 

      float f1 = 99988.88f;
      float f2 = 11.11111f;
      System.out.println(f1);
      System.out.println(f2);

      float f3 = f1 + f2;
      System.out.println(f3);
      // 99988.88
      //    11.11111
      //--------------
      // 99999.99111 -> 값이 짤림.

      double r = f1 + f2; // float + float = float 이미 결과에서 값이 왜곡된다.
      System.out.println(r);

      // 각각 유효자릿수 7자리 일지라도 결과는 유효자릿수를 넘어간다.


      double d1 = 99988.88;
      double d2 = 11.11111;
      System.out.println(d1);
      System.out.println(d2);

      double d3 = d1 + d2;
      System.out.println(d3);

      // 부동소수점 할때 왠만하면 더블 쓰는게 좋다. 

      f1 = 3.141592f;
      d1 = f1; // 컴파일 OK. 단 값은 왜곡될 수 있다. 들어가지지만 값이 왜곡
      System.out.println(d1);
      
      // f1 = d1; // 컴파일 오류!

      // 값을 계산 안한다 하면 float . 값을 계산한다 하면 double 쓰는게 좋다.
      // float 이 double 에 담길 떄 소수점 이하가 2진수로 바뀔때 정규화 시킬떄 오류가 날 수 밖에 없다.


    
   }
 }

