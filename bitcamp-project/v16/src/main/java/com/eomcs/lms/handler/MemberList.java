package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Member;

public class MemberList {

  static final int DEFAULT_CAPACITY = 2;
  
  Member[] list;
  int size = 0;
  
  public MemberList(){
  this.list = new Member[DEFAULT_CAPACITY];
  }
  
  public MemberList(int capacity) {
    if(capacity< DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Member[DEFAULT_CAPACITY];
    else
    this.list = new Member[capacity];
  }

  public Member[] toArray() {
    /*Member[] arr = new Member[this.size];
    for(int i = 0; i < this.size; i++){
      arr[i] = this.list[i];
    }
    return arr;
    */
    return Arrays.copyOf(this.list, this.size);
  }

  public void add(Member member) {
    if(this.size == this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      
      /*Member[] arr = new Member[newCapacity];
      for (int i = 0; i < this.list.length; i++) {
        arr[i] = this.list[i];
    }
      this.list = arr;
      */
      this.list = Arrays.copyOf(this.list, newCapacity);
      
    }
    this.list[this.size++] = member; 
  }
  
  
}
