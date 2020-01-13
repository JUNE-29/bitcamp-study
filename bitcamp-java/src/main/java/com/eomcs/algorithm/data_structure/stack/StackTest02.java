package com.eomcs.algorithm.data_structure.stack;

public class StackTest02 {

  public static void main(String[] args) {
    Stack2 stack2 = new Stack2();
    
    stack2.push("aaa");
    stack2.push("bbb");
    stack2.push("ccc");
    stack2.push("ddd");
    
    
    while(!stack2.empty())
      System.out.println(stack2.pop());
  }
}
