// 스레드 재사용- 4단계) wait() / notify() 사용

package com.eomcs.concurrent.ex6;

import java.util.Scanner;

public class Exam0140 {

  public static void main(String[] args) {


    class MyThread extends Thread {
      int count;

      public void setCount(int count) {
        this.count = count;

        synchronized (this) {
          // synchronized 블럭에서 지정한 객체의 사용을 기다리는 스레드에게
          // 작업을 시작할 것을 알린다.
          notify();
          // 이 객체를 사용하는 스레드에게
          // 이제 기다림을 끝내고 작업을 시작하라고 알린다.
          // notify()도 동기화 영역에서 호출해야한다.
          // 안그러면 IllegalMonitorStateException 예외가 발생한다.
        }
      }

      @Override
      public void run() {

        // 어떤 객체를 대상으로 여러 스레드가 동시에 사용하지 못하게 할 것인지
        // 지정해야 한다.
        // 동기화 블록 문법:
        // => synchronized(접근대상) {....}
        //
        synchronized (this) {
          System.out.println("스레드 시작했음!");
          try {
            while (true) {
              System.out.println("스레드 대기중............");
              wait();
              // 스레드를 시작하자 마자 일단 작업 지시를 기다리게 한다.
              // wait()는 반드시 동기화 영역 안에서 호출해야 한다.
              // 동기화 영역?
              // => synchronized로 선언된 메서드
              // => synchronized로 묶인 블록
              //
              // 기다림을 끝내는 방법?
              // => notify()를 통해 기다림이 끝났다는 것을 알림 받아야 한다.
              //
              System.out.println("카운트 시작!");
              for (int i = count; i > 0; i--) {
                System.out.println("==> " + i);
                Thread.sleep(1000);
              }
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
    }

    MyThread t = new MyThread();

    t.start();

    Scanner keyScan = new Scanner(System.in);

    while (true) {
      System.out.print("카운트? ");
      String str = keyScan.nextLine();
      if (str.equals("quit")) {
        break;
      }

      int count = Integer.parseInt(str);
      t.setCount(count);
      // 이 버전은 다음과 같이 동작한다.
      // => 스레드가 작업을 완료하면 10초 동안 잠든다.
      // => 10초 후에 깨어났을 때 카운트 값이 설정되어 있지 않으면 다시 잠든다.
      // => 카운트 값이 설정되면서 enable이 활성화 상태라면 작업을 실행한다.
      // => 작업이 끝나면 enable을 비활성으로 만든 후 잠든다.
      // 이전 버전에서는 깨어난 후 무조건 작업을 수행했지만
      // 이 버전은 카운트 값이 설정될 때만 작업하도록 개선하였다.
      // 그러나 근본적인 문제는 해결되지 않았다.
      // => 작업을 완료한 후 무조건 10초를 기다린다.
      // => 스레드가 깨어난 후 작업이 없더라도 10초를 기다린다.
    }

    System.out.println("main 스레드 종료!");
    keyScan.close();
  }
}


