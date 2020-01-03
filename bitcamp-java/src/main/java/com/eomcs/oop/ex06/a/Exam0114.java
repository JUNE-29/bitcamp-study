// 다형성 - 다형적 변수(polymorphic variables)
package com.eomcs.oop.ex06.a;

public class Exam0114 {

  public static void main(String[] args) {
    Vehicle v = new Vehicle();
    Bike b = new Bike();
    Car c = new Car();
    Sedan s = new Sedan();
    Truck t = new Truck();

    Car c2 = null;
    
    // 자식 클래스의 인스턴스는 가리킬 수 있다.
    // 왜?
    // => 자식 클래스의 인스턴스에는 부모 클래스의 인스턴스 변수가 있기 때문이다.
    //
    c2 = s; // OK!
    c2 = t; // OK!
    
    // => 그래서 다음과 같이 c2 레퍼런스가  Sadan 인스턴스를 가리킨다고 할 때
    //    c2로  Car 인스턴스의 변수를 사용할 수 있다.
    c2 = s;
    
    c2.model = "티코"; // Vehicle의 인스턴스 변수
    c2.capacity = 5;  // Vehicle의 인스턴스 변수
    c2.cc = 890;      // Car의 인스턴스 변수
    c2.valve = 16;    // Car의 인스턴스 변수
    
    Truck tr = new Truck();
    tr.model = "따란";
    tr.capacity = 5;
    tr.ton = 0;
    tr.cc = 500;
    tr.valve = 16;
    
    Car ca = new Truck();
    ca.model = "티코";
    ca.capacity = 5;
    ca.cc = 500;
    ca.valve = 16;
    ca.ton = 0;
    ((Truck)ca).ton = 0;
    ca.dump = true;
    
    
    Car ca = new Vehcile();
    ve.cc = 290;
    
  }

}
