package com.eomcs.oop.ex03.test;

public class Engine {
  int sylinder;
  int valve;
  int cc;
  int oilState;
  
  // 기본 생성자 말고 세개의 값을 설정하게끔 생성자를 정의.
  Engine(int sylinder, int valve, int cc) {
    this.sylinder = sylinder;
    this.valve = valve;
    this.cc = cc;
    this.oilState = 0;
    // 새로운 인스턴스 주소에 이 값들을 넣어진다. 세팅하는 느낌.
    // 인스턴스 주소 없이 호출이 되지 않는다.
  }
  
  void cleanOil() {
    this.oilState = 10;
    // this -> 엔진 데이터를 다루는 인스턴스 주소가 들어있다.
  }
}
