package com.eomcs.oop.ex03.test;

class Score {
  static int count; // 반복하니까 클래스변수로 만들어준다.
  
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;
  
  /*static void compute(Score s) {
    // 클래스 메소드는 파라미터로 값을 받아야함.
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3f;
  }*/
  
    static void increase() {
      Score.count++;
    }
  
   void compute() {
     // 인스턴스메소드
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
   
   Score() {
     // 생성자 : 인스턴스 생성된 후에 자동으로 호출된다.
     // 인스턴스의 유효한 값들로 초기화 시킨다.
     // 생성자에 값을 안주면 여기로 초기화 되고 값을 주면 밑에 생성자에 초기화 된다.
     System.out.println("Score()");
     Score.increase(); // 클래스메소드
   }
   
   Score(String name, int kor, int eng, int math) {
     // 생성자는 한개 이상 만들 수 있다.
     System.out.println("Score() - 2");
     this.name = name;
     this.kor  = kor;
     this.eng = eng;
     this.math = math;
     this.compute();
     Score.increase(); //클래스 메소드
   }
}

public class Test01 {

  public static void main(String[] args) {
    
    Score s1 = new Score(); 
    // new는 Heap 이라는 메모리에 만들어짐 , s1은 stack 메모리에 만들어짐.
    System.out.println("-----------------");
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 80;
    //Score.compute(s1); //클래스
    s1.compute();
    
    Score s2 = new Score("임꺽정", 90, 80, 70); 
    System.out.println("-----------------");
  }
}
