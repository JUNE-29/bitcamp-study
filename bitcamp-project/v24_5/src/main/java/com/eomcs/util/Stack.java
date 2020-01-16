package com.eomcs.util;

import java.util.Arrays;

public class Stack<E> implements Cloneable{
  
  private static final int DEFAULT_CAPACITY = 10;

  Object[] elementData;
  int size;
  
  public Stack() {
    this.elementData = new Object[DEFAULT_CAPACITY];
    this.size = 0;
  }
  
  public void push(E value) {
    if(this.size == elementData.length) {
      grow();
    }
    this.elementData[size++] = value;
    //size++;
  }
  
  private void grow() {
    // 내부에서 쓰일 메소드이기 때문에 private로!
    this.elementData = Arrays.copyOf(elementData, newCapacity());
  }
  
  private int newCapacity() {
    int oldCapacity = elementData.length;
    return oldCapacity + (oldCapacity >> 1);
  }
  
  public E pop() {
    if(this.empty())
      return null;
    E value = (E)this.elementData[--this.size];
    this.elementData[this.size] = null;
    // 객체에 주소가 남아있지 않도록 하겠다. 가비지가 생기도록.
    return value;
        // 전위연산자를 이용하여 size를 줄이고 찾는다.
  }
  
  public boolean empty() {
    return this.size == 0;
  }
  // Object.clone()의 'shallow copy' 이용하여 스택 객체 복사하기
  // 문제점?
  // => 데이터가 실제 저장된 배열은 복제하지 않는다.
  // => 그래서 배열의 값을 바꾸면 원본 스택에도 영향을 끼친다.
  /*
  @Override
  public Stack clone() {
    try {
    return (Stack)super.clone();
    // 예외가 발생할 수 있는 메소드를 담는다.
    } catch (CloneNotSupportedException ex) {
      // 위에 있는 try 식에 문제가 발생하면 여기서 처리
      // Object의 clone() 메서드는 복제가 허용된 객체의 대해서만
      // 해당 인스턴스 변수를 복제한다.
      // 복제가 허용되지 않은 객체에 대해서 clone()을 호출하면
      // CloneNotSupportedException 실행 오류가 발생한다.
      // 해결책?
      // => 해당 클래스의 객체를 복제할 수 있다고 표시하라! 복제 가능 표시하기! 
      // => 방법: Cloneable 인터페이스를 지정해야 한다.
      //    예) class MY implements Cloneable {..}
      
      System.out.println(ex);
      // == System.out.println(ex.toString()); 같다.
      return null;
    }
  } */
  
  // 'deep copy'를 이용하여 객체 복제하기
  // => 데이터가 들어있는 배열도 그대로 복제한다.
  // => 따라서 배열의 값을 바꾸더라도 원복 객체에 영향을 끼치지 않는다.
  //
  @SuppressWarnings("unchecked")
  @Override
  public Stack<E> clone() {
    try {
    // 1) 'shallow copy'를 통해 이 객체의 인스턴스 변수는 그대로 복제한다.
    Stack<E> temp = (Stack<E>) super.clone();
    
    // 2) elementData 배열을 복제한다.
    // => 배열만 복제하고 그 배열에 저장된 객체(ex: 문자열,Member객체 등)까지는 복제하지 않는다.
    // => 어디까지 복제(deep copy의 수준)할 것인지는 상황에 따라 결정한다.
    //
    Object[] arr = new Object[this.size];
    for(int i = 0; i < this.size; i++) {
      arr[i] = this.elementData[i];
    }
    
    // 3) 복제한 스택 객체가 새로 만든 배열을 가리키도록 한다.
    temp.elementData = arr;
    
    return temp;
    
    } catch (CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
    
  }
  
  public Iterator<E> iterator() {
    // anonymous class : 인스턴스를 한 개만 생성한다면 로컬 클래스를 익명 클래스로 정의하라.
    return new Iterator<E>() {
      
      Stack<E> stack= (Stack<E>) Stack.this.clone();
      
      @Override
      public boolean hasNext() {
        return !stack.empty();
      }
      
      @Override
      public E next() {
        return stack.pop();
      }
    };
  }
  
  
  /*
  static void m1() {
    // 스태틱 메서드는 다음과 클래스 이름으로 바로 호출할 수 있기 떄문에 this 변수가 없다.
    //      예) Stack.m1();
    //
    
    // 스태틱 메서드에서 로컬 클래스를 정의한다면
    // 그 로컬 클래스는 바깥 클래스의 인스턴스를 직접 접근할 수 없다.
    // 왜냐면 this가 없기 때문에.
    
    class A {
      A() {
        Stack s;
        //s = Stack.this; // 컴파일 오류!
        // 이 로컬 클래스는 m1()에서 사용할 것이다.
        // m1()은 바깥 클래스의 인스턴스 주소를 모른다.
        // 그런데 로컬 클래스에서 위와 같이 바깥 클래스의 인스턴스를 사용하려 한다면
        // 문제가 되는 것이다.
        // 이런 상황을 방지하고자 자바는 컴파일 오류를 발생시킨다.
      }
    }
  }
  */
  
}
