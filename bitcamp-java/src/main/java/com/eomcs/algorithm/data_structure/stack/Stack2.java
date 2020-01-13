package com.eomcs.algorithm.data_structure.stack;

import java.util.Arrays;

public class Stack2 implements Cloneable {

  private static final int DEFAULT_CAPACITY = 10;

  Object[] elementsData;
  int size;

  public Stack2() {
    this.elementsData = new Object[DEFAULT_CAPACITY];
    this.size = 0;
  }

  public void push(Object value) {
    if(this.size == elementsData.length) {
      grow();
    }
    this.elementsData[size++] = value;
  }

  private void grow() {

    this.elementsData = Arrays.copyOf(elementsData, newCapacity());
  }

  private int newCapacity() {
    int oldCapacity = elementsData.length;
    return oldCapacity + (oldCapacity >> 1);
  }

  public Object pop() {
    if(this.empty()) 
      return null;
    Object value = this.elementsData[--this.size];
    this.elementsData[this.size] = null;
    return value;
  }

  public boolean empty() {
    return this.size == 0;
  }
/*
  @Override
  public Stack clone() {
    try {
      return (Stack)super.clone();
    } catch (CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
  }
  */
  
  @Override
  protected Stack2 clone() {
    try {
      Stack2 temp = (Stack2) super.clone();
      
      Object[] arr = new Object[this.size];
      for(int i = 0; i < this.size; i++) {
        arr[i] = this.elementsData[i];
      }
      temp.elementsData = arr;
      return temp;
    } catch (CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
  }
}
