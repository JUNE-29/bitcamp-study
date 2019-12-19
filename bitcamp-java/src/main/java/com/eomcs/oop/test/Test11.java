package com.eomcs.oop.test;

// gym 회원 정보를 입력 받아 출력
public class Test11 {
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
    
    // 여러 개의 인스턴스 주소를 저장하려면 당연히 여러 개의 레퍼런스가 필요하다.
    //
    // 레퍼런스 변수를 여러 개 만들기
    Member m0, m1, m2, m3, m4;
    
    // 인스턴스를 생성하여 각 레퍼런스 (변수)에 저장하기
    m0 = new Member();
    m1 = new Member();
    m2 = new Member();
    m3 = new Member();
    m4 = new Member();
    
    m0.no = 100;
    m1.no = 200;
    m2.no = 300;
    m3.no = 400;
    m4.no = 500;
    
    
  }
 
}
