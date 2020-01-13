package com.eomcs.algorithm.data_structure.queue;

public class QueueTest {

  public static void main(String[] args) {

    Queue q = new Queue();
     
     q.offer("aaa");
     q.offer("bbb");
     q.offer("ccc");
     
     while (q.size() > 0) {
       // q에서 꺼낼게 있다면 계속 진행하라
       System.out.println("==>" + q.poll());
     }
  }
}
