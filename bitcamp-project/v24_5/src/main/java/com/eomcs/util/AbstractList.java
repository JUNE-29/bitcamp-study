package com.eomcs.util;


public abstract class AbstractList<E> implements List<E>{

  protected int size;


  public int size() {
    return this.size;
  }

  /*  다음은 로컬 클래스에 대한
 '의미 전달을 위해 간략하게 작성한 코드(pseudo;의사코드 = 가짜코드)'이다.
  class  클래스{
    필드
    블록
    생성자
    메서드 {
       this 사용
       로컬변수
       
       로컬(중첩) 클래스 {
          바깥 클래스.this 사용가능!! 
          로컬 변수 접근 가능!
      } 
    }
    
    중첩클래스 {
      바깥 클래스.this 사용
    }
  }

   */

// 바꾸기 전!!
//@Override
//  public Iterator<E> iterator() {
//    //this = 인스턴스 주소;
//    
//    
//    // anonymous class : 인스턴스는 한 개만 생성할 거면 익명 클래스로 정의하라.
//     Iterator<E> obj = new Iterator<E>() {
//      // 바깥 클래스의 파라미터를 바로 사용하기 때문에 <E>로 바꾼다.
//      // Iterator를 구현한 익명 클래스!
//      // 익명 클래스는 수퍼클래스를 상속 받거나 아니면 인터페이스를 구현하거나 한가지만.
//      List<E> list;
//      int cursor;
//
//      // 익명 클래스는 생성자를 만들 수 없기 때문에
//      // 인스턴스 필드를 초기화 시키기 위해서는
//      // 다음과 같이 인스턴스 블럭을 사용해야 한다.
//      // (물론 단순히 값을 할당하는 경우에는 인스턴스 블록에 넣지 않고
//      // 필드 선언에 바로 할당 연산자를 사용할 수 있다.)
//      {
//        this.list = (List<E>) AbstractList.this;
//      }
//
//      @Override
//      public boolean hasNext() {
//        return cursor < this.list.size();
//      }
//
//      @Override
//      public E next() {
//        return list.get(cursor++);
//      }
//    };
//
//    // 로컬 클래스는 인스턴스 멤버가 아니기 때문에 
//    // 앞쪽에 인스턴스 주소(this)를 전달해서는 안된다.
//    // 즉 this. 을 붙여서는 안된다.
//    return obj;
//  }
  
  
  @Override
  public Iterator<E> iterator() {
  
    // 이 클래스코드를 리턴하는게 아니라 인스턴스의 주소를 리턴하는것!
    // 예) return 200; 처럼!
  return new Iterator<E>() {
    
    List<E> list;
    int cursor;

    {
      this.list = (List<E>) AbstractList.this;
    }

    @Override
    public boolean hasNext() {
      return cursor < this.list.size();
    }

    @Override
    public E next() {
      return list.get(cursor++);
    }
  };
 }
}
