package com.eomcs.algorithm.data_structure.stack;

import java.util.Arrays;

public class Stack2 {

  private static final int DAFAULT_CAPACITY = 10;
  
  Object[] elementData;
  int size;
  
  public Stack2() {
    this.elementData = new Object[DAFAULT_CAPACITY];
    this.size = 0;
  }
  
  public void push(Object value) {
    this.elementData[this.size++] = value;
    
  }
  
}
