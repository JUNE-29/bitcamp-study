package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Lesson;

public class LessonList {
  
  static final int DEFAULT_CAPACITY = 3;
  
  Lesson[] list;
  int size = 0;
  
  
  public LessonList() {
    this.list = new Lesson[DEFAULT_CAPACITY];
  }
  
  public LessonList(int capacity) {
    if(capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Lesson[DEFAULT_CAPACITY];
    else
      this.list = new Lesson[capacity];
  }
  
  public Lesson[] toArray() {
    /*Lesson[] arr = new Lesson[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.list[i];
      }
    return arr;
    */
    return Arrays.copyOf(this.list, this.size);
  }
  
  public void add(Lesson lesson) {
    if(this.size == this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      
      /*Lesson[] arr = new Lesson[newCapacity];
      for (int i = 0; i < this.list.length; i++) {
        arr[i] = this.list[i];
      }
      this.list = arr; 
      */
      this.list = Arrays.copyOf(this.list, newCapacity);
    }
    this.list[this.size++] = lesson;
  }
  
}
