package com.eomcs.basic.ex03;

// 문자열 리터럴(literal)

public class Exam6 {
  public static void main(String[] args) {
    // 큰 따옴표("") 사용하여 문자열을 나열한다.
    System.out.println("홍길동");
    System.out.println("가"); // 문자가 아니라 문자열이다!

    // + 연산자(operater; 특정기능을 수행하는 명령)를 이용하여
    // 여러 개의 문자열을 하나로 합쳐 새 문자열을 만든다.
    System.out.println("홍길동"+ "입니다.");

    //문자열과 다른 종류의 값을 더한다?
    // => 다른 종류의 값을 문자열로 변환한 후 (20 -> 문자열로 바뀜 / false -> 문자열로 바뀜)
    //    기존 문자열에 결합하여 새 문자열을 만든다.
    System.out.println("홍길동은" + 20 + "살입니다.");
    System.out.println("취업여부:" + false);
    System.out.println("키:" + 180.7f); // f는 값이 아니기 때문에 문자열로 바뀌지 않는다.

  }
}

// 문자열의 저장?
// - 자바는 char(2byte) 배열(여러 개의 메모리)에
//   문자열의 유니코드(Unicode; UCS-2)를 저장한다.
// - 예) "AB가각"
//      [0041][0042][ac00][ac01] <== 2바이트 메모리에 4개에 저장됨. 8바이트에 저장됨.