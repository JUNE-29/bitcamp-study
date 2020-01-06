package com.eomcs.basic.ex05;

// 논리 연산자 : && vs &
//
public class Exam0330 {
  public static void main(String[] args) {
    boolean a = false;
    boolean b = false;
    boolean r = a && (b = true); 
    // 계산 순서
    // r = a && (b = true)
    // r = false && (b = true)
    // => && 연산에서 왼쪽 값이 이미 false이기 때문에 결과는 확정되었다.
    // => 이렇게 && 연산의 오른 쪽을 실행하기 전에 결과를 알 수 있다면 
    //    굳이 && 연산의 오른쪽을 실행하지 않는다.
    // => 그래서 (b = true) 문장은 실행되지 않는다.
    // r = false
    System.out.printf("a=%b, b=%b, r=%b\n", a, b, r);

    a = false;
    b = false;
    r = a & (b = true);
    // 계산 순서
    // r = a &(b = true)
    // r = false & (b = true)
    // => & 연산ㄴ자의 경우 왼쪽값으로 결과를 에측할 수 있다 하더라도,
    //    
    System.out.printf("a=%b, b=%b, r=%b\n", a, b, r);
  }
}
// &&, ||
// - 앞의 피연산자의 값으로 결과를 알 수 있다면 뒤의 명령은 실행하지 않는다.
// 
// &, |
// - 앞의 피연산자로 결과를 알 수 있을 지라도, 
//   뒤에 놓은 명령까지 모두 실행한다.