package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> {

  static final int DEFAULT_CAPACITY = 3;

  Object[] list; // E[] 하면 안된다. E는 배열을 만들 수 없다.
  int size = 0;

  public ArrayList() {
    this.list = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int capacity) {
    if(capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Object[DEFAULT_CAPACITY];
    else
      this.list = new Object[capacity];
  }

  @SuppressWarnings({"unchecked"})
  public E[] toArray(E[] arr) {
    // toArray(Class arrType) 클래스 정보를 달라고..
    // copyOf() 메서드야,
    // arrayType 에 지정된 배열을 size 만큼 만들어라.
    // 그리고 list 배열에 저장된 주소를 새로 만든 배열에 복사하라.
    // 마지막으로 새로 만든 배열의 주소를 리턴하라!
    if(arr.length < this.size) {
      return (E[]) Arrays.copyOf(this.list, this.size, arr.getClass());
      //this.size 만큼 만들어서 this.list를 복사해서 새로 배열을 만들어라! 
      }
    System.arraycopy(this.list, 0, arr, 0, this.size);
    // this.list에 있는 것을 this.size 만큼 0번부터 꺼내 arr에 복사한다.
    
    /*
     // 위의 arraycopy()는 다음 코드와 같다.
     for (int i = 0; i < arr.length; i++) {
      arr[i] = (E) this.list[i];
    }
    */
    return arr;
  }

  public void add(E obj) {
    if (this.size == this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
    }
    this.list[this.size++] = obj;
  }

  @SuppressWarnings("unchecked")
  public E get(int idx) {
    if (idx >= 0 && idx < this.size) {
      return (E)this.list[idx];
    } else {
      return null;
    }
  }
  
  public int size() {
    return this.size;
  }
}
