package com.eomcs.oop.ex11.c.step3;

public class Product {
  // 카테고리 값을 잘못 입력할 경우를 방지하기 위해
  // 문자열을 상수로 정의한다.
  public static final String applience_tv = "applience/tv";
  public static final String computer_ram = "computer/ram";
  public static final String book_novel = "book/novel";

  // 카테고리를 문자열로 받는다면?
  String category;
  String name;
  String maker;
  int price;
}
