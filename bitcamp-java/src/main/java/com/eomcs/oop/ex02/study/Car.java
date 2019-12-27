package com.eomcs.oop.ex02.study;

public class Car {

  public static final int OIL = 1;
  public static final int GAS = 2;

  // 인스턴스 필드 : 인스턴스를 생성하기 위한 필드
  String name;
  int type;
  String color;
  int speed;
  int energy;
  int power;
  int cleanLevel;

  // 밑에들은 Car 데이터를 다루는 연산자들!
  void speedUp() {
    // Car this = 메서드를 호출 할때 넘겨준 인스턴스 주소; 히든변수
    // static은 this 라는 변수가 없다. 오로지 인스턴스에서만 가능.
    if (this.speed >= 100) 
      return;
    this.speed += 10;
  }

  int comparePower(Car c) {
    if(this.power > c.power)
      return -1;
    else if (this.power ==  c.power)
      return 0;
    else
      return 1;
  }
} 
