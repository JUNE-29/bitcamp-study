package com.eomcs.algorithm.data_structure.linkedlist;

public class LinkedListTest03 {
  public static void main(String[] args) {
  LinkedList2 list = new LinkedList2();
  
  list.add("aaa");
  list.add("bbb");
  list.add("ccc");
  list.add("ddd");
  list.add("eee");
  list.add("fff");
  list.add("ggg");
  
  
   list.add(2,"xxx");
   
   print(list);

  }
  static void print(LinkedList2 list) {
    for(int i = 0; i < list.size; i++) {
      System.out.println(list.get(i));
    }
  } 
}
