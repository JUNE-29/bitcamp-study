package com.eomcs.util;

public class ArrayListTest2 {
  public static void main(String[] args) {
    ArrayList2 a1 = new ArrayList2();
    
    a1.add("abcd");
    
    System.out.println(a1.get(0));
    
    a1.set("aaa");
    
    System.out.println(a1.get(0));
  }
}
