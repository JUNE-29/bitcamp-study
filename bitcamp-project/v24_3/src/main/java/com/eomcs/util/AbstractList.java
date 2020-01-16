package com.eomcs.util;


public abstract class AbstractList<E> implements List<E>{
  
  protected int size;
  
  
  public int size() {
    return this.size;
  }
  
  @Override
  public Iterator<E> iterator() {
    //this = 인스턴스 주소;
    // List 객체에서 값을 꺼내주는 일을 할 Iterator 구현체를 준비하여 리턴한다.
    return new ListIterator<E>();
    // new ListIterator는 List의 주소를 알고있다.
    // 원래 this.new ListIterator<E>(); 이고 this가 생략됨.
  }
  
  // non - static nested class = inner class
  // inner class의 인스턴스를 만들려면 바깥의 인스턴스 주소가 있어야 한다.
  class ListIterator<T> implements Iterator<T> {
    // 바깥 클래스와 다르게 'T' 라고 하기. 
    List<T> list;
    int cursor;
    
    @SuppressWarnings("unchecked")
    public ListIterator () {
      this.list = (List<T>) AbstractList.this;
      //this.list = this; 하게 되면 이 클래스의 this를 담게 되는것이다.
    }
    
    @Override
    public boolean hasNext() {
      return cursor < this.list.size();
    }
    
    @Override
    public T next() {
      return list.get(cursor++);
    }
  }
  

}
