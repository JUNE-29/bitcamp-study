package com.eomcs.oop.ex03.test;

public class Car {

  boolean on;
  int speed;
  String model;
  String maker;
  Engine engine;
  int distance;
  
  // 생성자 : 인스턴스가 제대로 다뤄질 수 있도록 유효한 값들로 적절하게 설정하는것(세팅)
  Car() {
    this.engine = new Engine(4, 16, 1980);
    // 기본 생성자에 엔진 객체를 만들어 꼽아줘야 한다. 엔진 객체를 만들어주기 
  }
 
  //static void start(Car c){..} -> 클래스메소드 파라미터로 값을 받았다.
  void start() {
    this.on = true;
    // 모든 인스턴스 메소드는 내장 히든 변수 this로 받는다.
    // 메소드를 호출할때 넘겨준 인스턴스 주소 : this ! 설계도에 있는 변수가 this가 아니다.
    // this에 인스턴스 주소가 들어있다는 것!
  }
  
  void stop() {
    on = false;
  }
  
  void check() {
    // this -> car의 데이터를 다루는 인스턴스 주소가 들어있다.
    if(this.engine.oilState == 0) {
      this.engine.cleanOil();
      System.out.println("자동차의 엔진 오일을 교환했습니다!");
    }
    System.out.println("자동차를 정비했습니다.");
  }
  /*
  void cleanOil() {
    this.engine.oilState = 10;
  }
  // 이 메소드는 잘못 되었다. 엔진의 데이터를 다루는 연산자니까 이 클래스에 있으면 안된다.
  */
}

