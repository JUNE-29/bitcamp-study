// 클라이언트 + 키보드 입력
package com.eomcs.net.ex01;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender2 {

  public static void main(String[] args) throws Exception {

    System.out.println("클라이언트 실행!");

    Scanner keyScan = new Scanner(System.in);

    Socket socket = new Socket("192.168.1.121", 8888);

    PrintStream out = new PrintStream(socket.getOutputStream());
    Scanner in = new Scanner(socket.getInputStream());

    // 키보드 입력을 받아서 서버에게 전송한다.
    System.out.print("입력> ");
    String input = keyScan.nextLine();
    out.println(input);

    // 서버가 보낸 데이터를 수신한다.
    String str = in.nextLine(); // 줄바꿈 코드가 들어올때 까지 기다리다가 그전 까지 읽었던 것을 담는다.
    System.out.println(str);

    in.close();
    out.close();
    socket.close();
    keyScan.close();
  }

}


