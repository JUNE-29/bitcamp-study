package com.eomcs.algorithm.data_structure.array;

public class ArrayListTest2 {
  public static void main(String[] args) {
    
    ArrayList2 a1 = new ArrayList2();
    
    a1.add("abcd");
    a1.add("bbbvv");
    
    System.out.println(a1.get(0));
    System.out.println(a1.get(1));
    
    a1.set(0,"aaa");
    a1.set(1, "ccc");
    
    System.out.println(a1.get(0));
    System.out.println(a1.get(1));
  }
}
