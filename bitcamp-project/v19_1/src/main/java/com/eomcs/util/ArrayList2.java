package com.eomcs.util;

public class ArrayList2 {

  private static final int DEFAULT_CAPACITY = 10;

  Object[] elementDate = new Object[100];
  int size;

  public ArrayList2() {
    this.elementDate = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList2(int initialCapacity) {
    if(initialCapacity < DEFAULT_CAPACITY) {
      this.elementDate = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementDate = new Object[initialCapacity];
    }
  }

  public void add(Object e) {
    this.elementDate[this.size++] = e;
  }
  
  public Object get(int index) {
    return this.elementDate[index];
  }
  
  public void set(int index, Object e) {
    this.elementDate[index] = e;
  }
  
  public void remove(int index) {
    for (int i = index + 1; i < this.size; i++) {
      this.elementDate[i - 1] = this.elementDate[i];
    }
  }

}
