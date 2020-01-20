// contains() 와 equals()의 관계
package com.eomcs.corelib.ex03;

public class Exam0210 {
  public static void main(String[] args) {
    String s1 = new String("aaa");
    String s2 = new String("bbb");
    String s3 = new String("ccc");
    String s4 = new String("bbb"); // s2 != s4

    ArrayList list = new ArrayList();
    list.add(s1);
    list.add(s2);
    list.add(s3);
    print(list);

    // contains()가 값을 비교할 때는
    // equals()의 결과가 true 인지 비교한다.
    // 결론!
    // => String 클래스의 경우 equals()를 오버라이딩 했기 때문에
    // 서로 다른 개체(s2와 s4)라도 값이 같으면 같은 객체로 간주한다.
    // => 그래서 다음 코드의 실행 결과는 true이다.

    // java.util.ArrayList의 contains() 메서드는
    // 목록에 들어있는 객체를 찾을 때 equals()로 두 객체가 같은지 비교한다.
    // equals()리턴 값이 true라면
    // 같은 객체가 있다면 뜻으로 true를 리턴하고, 못찾았다면 false를 리턴한다.
    // 그래서 s2와 s4가 비록 다른 인스턴스이지만, 같은 객체로 판단한 것이다.
    //
    System.out.println(list.contains(s4)); // true
  }

  static void print(ArrayList list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + ", ");
    }
    System.out.println();
  }
}
