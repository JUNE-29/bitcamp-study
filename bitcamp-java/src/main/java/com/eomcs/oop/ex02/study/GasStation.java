package com.eomcs.oop.ex02.study;

public class GasStation {
  String name;
  int type;

  int refuel(Car c) {
    if(c.type != this.type)
      return 0;
    int amount = 100 - c.energy;
    c.energy = 100;
    return amount;
  }

  // 인스턴스 필드, 메서드를 사용하지 않는 경우는 static을 붙인다.
  // 왜냐하면 int type을 쓰지 않으니까. 특정 인스턴스를 사용하지 않으니까!
  static void clean(Car c) {
    c.cleanLevel = 0;
  }
}
