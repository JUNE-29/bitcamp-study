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
      }
    System.arraycopy(this.list, 0, arr, 0, this.size);
    
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
  
  @SuppressWarnings("unchecked")
  public E set(int index, E obj) {
    if (index < 0 || index >= this.size)
      return null;
    
    E old = (E) this.list[index];
    this.list[index] = obj;
    
    return old;
  }

  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= this.size)
      return null;
    
    // 삭제할 항목을 따로 보관해 둔다.
    E old = (E) this.list[index];
    
    for (int i = index + 1; i < this.size; i++) {
      this.list[i - 1] = this.list[i];
      
    }
    
    this.size--;
    this.list[this.size] = null;
    
    // 삭제한 항목을 리턴한다.
    return old;
  }
  
  
  public int size() {
    return this.size;
  }
  
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    list.add("eee");
    list.add("fff");
    
//    list.remove(6);
    
//    list.set(0, "0000");
//    list.set(3, "3333");
//    list.set(5, "5555");
//    list.set(-1, "zzzzz");
//    list.set(6, "^^^^^");
    
    
    String[] arr = list.toArray(new String[] {});
    for(String s : arr ) {
    System.out.println(s);
    }
  }
}
