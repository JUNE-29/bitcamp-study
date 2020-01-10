package com.eomcs.algorithm.data_structure.linkedlist;

public class LinkedList2 {
  
 Node first;
  
  Node last;
  
  int size;
  
  
  public void add(Object value) {
    Node newNode = new Node();
    newNode.value = value;
    
    if(this.first == null) {
      last = first = newNode;
    }else {
      last.next = newNode;
      last = newNode;
    }
    
    this.size++;
  }
  
  public Object get(int index) {
    if(index < 0 || index >= size)
      return null;
    
    Node cursor = first;
    for(int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    
    return cursor.value;
  }
  
  public void add(int index, Object value) {
    
    if(index < 0 || index >= size)
      return;
    
    Node newNode = new Node();
    newNode.value = value;
    
    Node cursor = first;
    for(int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    } 
    
    if (index == 0) {
      newNode.next = first;
      first = newNode;
    } else {
    newNode.next = cursor.next;
    // 다음주소를 새커서에 그 주소를 집어 넣는다.
    cursor.next = newNode;
    // 그 전의 커서의 주소에 새로운 주소를 넣는다.
    }
    this.size++;
  }
  
  static class Node {
    Object value;
    Node next;
  }
}
