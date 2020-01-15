package com.eomcs.util;

import java.lang.reflect.Array;

public class LinkedList<E> {
  
  Node<E> first;
  
  Node<E> last;
  
  int size;
  
  
  public void add(E value) {
    Node<E> newNode = new Node<>();
    newNode.value = value;
    
    if(this.first == null) {
      last = first = newNode;
    }else {
      last.next = newNode;
      last = newNode;
    }
    
    this.size++;
  }
  
  public E get(int index) {
    if(index < 0 || index >= size)
      return null;
    
    Node<E> cursor = first;
    for(int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    
    return cursor.value;
  }
  
  public void add(int index, E value) {
    if(index < 0 || index >= size)
      return;
    
    Node<E> newNode = new Node<>();
    newNode.value = value;
    
    Node<E> cursor = first;
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
  
  public E remove (int index) {
    if(index < 0 || index >= size)
      return null;
    
    Node<E> cursor = first;
    for(int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
      // 전 커서를 찾는 식
    } 
    
    Node<E> deletedNode = null;
    if (index == 0) {
      deletedNode = first;
      first = deletedNode.next;
    } else {
    deletedNode = cursor.next;
    cursor.next = deletedNode.next;
    // 삭제할 코드의 다음 주소를 현재 커서 다음주소에 넣는다.
    }
    
    deletedNode.next = null;
    size--;
    
    return deletedNode.value;
  }
  
  public E set(int index, E value) {
    if(index < 0 || index >= size)
      return null;
    // 찾는 식
    
    Node<E> cursor = first;
    for(int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    
    E oldValue = cursor.value;
    cursor.value = value;
    
    return oldValue;
  }
  
  public Object[] toArray() {
    Object[] arr = new Object[size];
    
    Node<E> cursor = first;
    for(int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }
    
    return arr;
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
   
    if(arr.length < size) {
      arr = (E[])Array.newInstance(arr.getClass().getComponentType(), size);
      // 배열의 한 항목을 달라고... size 만큼 만들거다.
      //파라미터로 받은 배열을 쓰면 안되고 새로 배열을 만들어야할때
    }
    
    Node<E> cursor = first;
    for(int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }
    
    return arr;
  }
  
  public int size() {
    return this.size;
  }
  
  static class Node<T> {
    T value;
    Node<T> next;
  }
}
