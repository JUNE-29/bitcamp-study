package com.eomcs.algorithm.data_structure.array;

public class ArrayList2 {

  private static final int DEFAULT_CAPACITY = 10;

  Object[] elementDate;
  int size;

  ArrayList2() {
    this.elementDate = new Object[DEFAULT_CAPACITY];
  }

  ArrayList2(int initialCapacity) {
    if(initialCapacity < DEFAULT_CAPACITY) {
      this.elementDate = new Object[DEFAULT_CAPACITY];
    }else {
      this.elementDate = new Object[initialCapacity];
    }
  }

  public void add(Object e) {
    if (this.size == this.elementDate.length) {

    }
    
  }
  
  public Object get(int index) {
    return this.elementDate[index];
  }
  
  public void set(int index, Object e) {
    this.elementDate[index] = e;
  }

  public void remove(int index) {
    for( int i = index + 1; i < this.size; i++) {
      this.elementDate[i - 1] = this.elementDate[i];
    }
    this.size --;
  }
  
  
}
