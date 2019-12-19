package com.eomcs.oop.test;

// gym 회원 정보를 입력 받아 출력
public class Test07 {
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
    
    
    Member m1;
    m1 = new Member();
    m1.no = 100;
    System.out.println(m1.no);
    
    Member m2 = m1;
    
    // 기존 레퍼런스에 새 인스턴스의 주소를 저장한다.
    // 따라서 m1과 m2는 서로 다른 인스턴스의 주소를 갖고 있다.
    // 즉 m1과 m2가 가리키는 인스턴스가 다르다.
    m1 = new Member();
    m1.no = 200;
    
    m2 = m1;
    
    // 이제 m2도 m1과 같은 인슽언스 주소를 갖고 있다.
    // 즉 같은 인스턴스를 가리킨다.
    // 처음에 만들었던 인스턴스는 주소를 잃어버려 사용할 수 없다.
    // 이렇게 주소를 잃어버려 사용할 수 없는 인스턴스를 "가비지 (garbage)"라 부른다.
    
  }
 
}
