// 상수를 활용하여 분류 코드를 다루기
package com.eomcs.oop.ex11.c.step4;


public class Exam0110 {
  public static void main(String[] args) {
    // 카테고리 값을 정수로 정의 하면 메모리가 절약 된다.
    // 카테고리 값을 상수로 정의하면 따로 주석을 달 필요가 없다.
    // 또한 상수의 이름을 대문자로 하면 상수임을 직관적으로 알 수 있다.
    //
    Product p = new Product();
    p.category = Product.APPLIANCE_TV;
    p.name = "울트라비전 뷰";
    p.price = 2000000;

    Product p2 = new Product();
    p2.category = Product.COMPUTER_RAM;
    p2.name = "삼성모듈램 4GB";
    p2.price = 80000;

    Product p3 = new Product();
    p3.category = Product.BOOK_NOVEL; // <== 잘못된 값을 넣을 수 없다!
    p3.name = "토지";
    p3.price = 18000;

    // 제품의 카테고리 값처럼 고정된 값은
    // 상수로 정의해 놓고 쓰면 코드를 작성할 때
    // 오타를 줄일 수 있고 코드를 읽는것이 쉬워진다.
  }
}
