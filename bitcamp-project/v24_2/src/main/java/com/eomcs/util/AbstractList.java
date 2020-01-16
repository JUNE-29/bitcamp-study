package com.eomcs.util;


public abstract class AbstractList<E> implements List<E>{
  
  protected int size;
  
  
  public int size() {
    return this.size;
  }
  
  @Override
  public Iterator<E> iterator() {
    // List 객체에서 값을 꺼내주는 일을 할 Iterator 구현체를 준비하여 리턴한다.
    return new ListIterator<E>(this);
    // this는 LinkedList나 ArrayList를 뜻한다
  }
  
  // static 으로 선언! 공개 할 필요없으니까! 여기에서만 쓸 것 이니까!
  static class ListIterator<E> implements Iterator<E> {
    
    List<E> list;
    int cursor;
    
    public ListIterator (List<E> list) {
      this.list = list;
    }
    
    @Override
    public boolean hasNext() {
      return cursor < this.list.size();
    }
    
    @Override
    public E next() {
      return list.get(cursor++);
    }
  }
  

}
