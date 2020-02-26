package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class ServerAppTest {

  public static void main(String[] args) {

    String serverAddr = null;
    int port = 0;

    // 키보드 스캐너 준비
    Scanner keyScan = new Scanner(System.in);

    try {

      // 사용자로부터 접속할 서버의 주소와 포트 번호를 입력 받는다.
      System.out.print("서버? ");
      serverAddr = keyScan.nextLine();

      System.out.print("포트? ");
      port = Integer.parseInt(keyScan.nextLine());

    } catch (Exception e) {
      System.out.println("서버 주소 또는 포트 번호가 유효하지 않습니다!");
      keyScan.close();
      return;
    }


    try (
        // 서버와 연결
        Socket socket = new Socket(serverAddr, port);
        PrintStream out = new PrintStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      System.out.println("서버와 연결되었음!");

      System.out.print("서버에 보낼 메시지: ");
      String sendMsg = keyScan.nextLine();

      out.println(sendMsg); // 이것을 전송하기 위해 PrintStream을 사용함
      System.out.println("서버에 메시지를 전송하였음!");

      String message = in.readUTF();
      System.out.println("서버로부터 응답 결과를 수신하였음!");

      System.out.println("서버: " + message);
      if (message.equals("OK")) {
        List<Board> list = (List<Board>) in.readObject();
        for (Board b : list) {
          System.out.println(b);
        }
      }

      System.out.println("서버와 연결을 끊었음!");

    } catch (Exception e) {
      System.out.println("예외 발생");
      e.printStackTrace(); // 예외가 왜 발생했는지 거꾸로 다 출력해준다.
    }

    keyScan.close();


  }

}
