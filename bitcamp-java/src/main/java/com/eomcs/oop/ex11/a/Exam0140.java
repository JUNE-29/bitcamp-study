// static nested class == inner class
package com.eomcs.oop.ex11.a;

// 다음과 같이 import static 문법을 이용하여
// 특정 클래스의 스태틱 멤버를 미리 선언해 둘 수 있다.
// 그러면 멤버를 사용할 때 일일이 클래스 이름을 지정할 필요가 없다.
//import static com.eomcs.oop.ex11.a.Exam0130_X.sValue;
//import com.eomcs.oop.ex11.a.Exam0130_X.A;

// 각각 멤버를 지정하는 대신
// 다음과 같이 wildcard(*)를 사용하여 전체 멤버를 지정할 수 있다.
import static com.eomcs.oop.ex11.a.Exam0130_X.*;

public class Exam0140 {
  public static void main(String[] args) {
    // import static을 이용하면 패키지 멤버 클래스를 사용하는 것과 똑같은 방법으로 
    // 클래스 이름을 생략할 수 있다.
    sValue = 100;

    // static nested class 또한 같은 방식으로 사용할 수 있다.
    A obj;
    obj = new A();


  }

}
