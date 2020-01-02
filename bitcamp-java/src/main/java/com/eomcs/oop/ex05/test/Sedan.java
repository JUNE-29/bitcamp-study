package com.eomcs.oop.ex05.test;

public class Sedan extends Car {
  // Car  수퍼클래스(Super class) = Parents class / Sedan = 서브클래스 (Sub class)= Child class
  
  public boolean sunroof;
  public boolean auto;

  public Sedan() {}

  public Sedan(String model, String maker, int capacity,
      boolean sunroof, boolean auto) {
    //this(model, maker, capacity); -> 쓸 수 없음. 왜냐하면 필드 없음.
    super(model, maker, capacity);
    this.sunroof = sunroof;
    this.auto = auto;
  }
}
