package com.eomcs.algorithm.data_structure.queue;

import com.eomcs.algorithm.data_structure.linkedlist.LinkedList;

public class Queue2<E> extends LinkedList<E> implements Cloneable{

  public void offer(E value) {
    this.add(value);
  }
  
  public E poll() {
    return this.remove(0);
  }
  
  
  /*
  public Queue clone() {
    try {
      return (Queue)super.clone();
    } catch (CloneNotSupportedException ex) {
      System.out.println(ex);
      return null;
    }
  }
  */
  
  @Override
  public Queue2<E> clone() {
    Queue2<E> temp = new Queue2<E>();
    
    for(int i = 0; i < this.size(); i++) {
      temp.offer(this.get(i));
    }
    return temp;
  }
}
