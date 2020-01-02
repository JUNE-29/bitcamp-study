package com.eomcs.oop.ex05.test;

public class A {

  int v1;

  A (){
    this(100); 
    //-> 현재 생성자에서 다른 생성자를 가르키고 호출한다.반드시 첫번째에 와야한다. this 앞에 아무것도 오면 안된다.
    System.out.println("A()");
  }

  A (int v1){
    this.v1 = v1;
    System.out.println("A(int)");
    System.out.println(v1);
  }
  
}
