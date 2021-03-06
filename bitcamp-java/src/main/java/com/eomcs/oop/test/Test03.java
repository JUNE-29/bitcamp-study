package com.eomcs.oop.test;

// gym 회원 정보를 입력 받아 출력
public class Test03 {
  public static void main(String[] args) {
    
    // 대신 자바는 다양한 종류의 데이터를 담을 수 있는 메모리를 설계하는 문법을 제공한다.
    
    // 예2: 회원 데이터를 저장할 메모리를 설계한다.
    class Member {
    int no;
    String name;
    int birthYear;
    char gender;
    float height;
    float weight;
    boolean persnalTraining;
    }
    
    // 자바 원시 데이터 타입은 그냥 변수를 선언하는 순간 메모리도 준비된다.
    // 변수가 곧 메모리이다.
    int i;
    
    i = 100; //OK!
    
    // 그러나 레퍼런스는 메모리의 주소를 담는 변수다.
    // 레퍼런스를 선언했다고 해서 해당 설계도의 메모리가 준비되는 것은 아니다.
    Member m1;
    
    // m1은 메모리에 주소를 저장하는 변수이다.
    // 주소를 저장하지 않고 사용할 수 없다.
    // m1.no = 100;
    
    // m1을 사용하려면 메모리(인스턴스)를 생성한 다음에 주소를 할당해야 한다.
    m1 = new Member();
    
    m1.no = 100;
    
    
  }
 
}
