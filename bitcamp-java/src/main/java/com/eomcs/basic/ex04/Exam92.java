package com.eomcs.basic.ex04;

// 형변환 : 부동소수점 변수  ==> 정수 변수
public class Exam92{

  public static void main(String[] args ){
    float f = 3.14f;
    double d = 3.14;

    int i;
    long l;

    //     i = f; //컴파일오류!
    //     i = l; //컴파일오류!
    //     i = d; //컴파일오류!
    //     l = f; //컴파일오류!
    //     l = d; //컴파일오류!
    
    // 부동소수점 메모리의 값을 정수 메모리에 저장할 때
    // 값이 짤릴 수 있음을 알면서도 정수 메모리에 저장해야 할 때가 있다.
    // 또는 큰 메모리의 값을 작은 메모리에 저장해야 할 때가 있다.

    //부동소수점 값을 정수 변수에 강제로 저장시키려면
    // 형변환(type conversion; type casting) 문법을 사용해야 한다.
    i = (int) f; // 소수점 이하의 수는 제거되고 정수만 저장된다.
    System.out.println(i);

    i = (int) d; //ok
    System.out.println(i);

    l = (long) f; //ok
    l = (long) d; //ok
    System.out.println(l);
    System.out.println(l);

    // 이렇게 개발자가 명확하게 다른 형의 값을 저장하라고 지시하는 문법을 
    // "명시적 형변환(explicit type conversion/casting)"이라 한다.
    // 명시적 형변환
    // - 큰 메모리의 값을 작은 메모리로 변환 할 때 
    // - 부동소수점을 정수로 변환 할 때  
    // - 문법
    //   변수 = (바꾸고자하는타입) 변수 또는 값;

  }
}

