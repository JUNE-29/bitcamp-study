// LMS 서버
package com.eomcs.lms;

import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;

public class ServerApp {

  // 옵저버 관련 코드
  // 옵저버 목록을 관리할 객체 준비
  Set<ApplicationContextListener> listeners = new HashSet<>();

  // 옵저버와 공유할 값을 보관할 객체를 준비한다. (옵저버 사이에 데이터를 주고받는 것)
  Map<String, Object> context = new HashMap<>();

  // 옵저버를 등록하는 메서드이다.
  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  // 옵저버를 제거하는 메서드이다.
  public void removeApplicationContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }

  // 애플리케이션이 시작 될 때 등록된 리스너에게 알린다.(옵저버 호출)
  private void notifyApplicationInitialized() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(context);
    }
  }

  // 애플리케이션이 종료되면 등록된 리스너에게 알린다.(옵저버 호출)
  private void notifyApplicationDestroyed() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed(context);
    }
  }
  // 옵저버 관련코드 끝


  public void service() {

    // 애플리케이션이 시작되면 등록된 옵저버를 실행한다.
    // 즉 DataLoaderListener를 실행한다!
    notifyApplicationInitialized();

    // 옵저버의 실행이 끝났으면 DataLoaderListener 옵저버가 준비한 List 객체를 꺼낸다.
    List<Board> boardList = (List<Board>) context.get("boardList");
    List<Lesson> lessonList = (List<Lesson>) context.get("lessonList");
    List<Member> memberList = (List<Member>) context.get("memberList");

    notifyApplicationDestroyed();

  } // service()


  public static void main(String[] args) {
    System.out.println("서버 수업 관리 시스템입니다.");

    ServerApp app = new ServerApp();

    app.addApplicationContextListener(new DataLoaderListener());
    app.service();

    /*
      try ( // 서버쪽 연결 준비 // => 클라이언트의 연결을 9999번 포트에서 기다린다. ex) 병원대기실 ServerSocket serverSocket =
      new ServerSocket(9999);) {
     
      System.out.println("클라이언트 연결 대기중....");
     
      while (true) { // 서버에 대기하고 있는 클라이언트와 연결 // => 대기하고 있는 클라이언트와 연결될 때까지 리턴하지 않는다. Socket socket
      = serverSocket.accept(); System.out.println("클라이언트와 연결되었음!");
     
      // 클라이언트의 요청 처리 processRequest(socket);
     
     System.out.println("------------------요청처리 끝--------------------"); }
     
     } catch (Exception e) { System.out.println("서버 준비 중 오류 발생!"); return; }
     */
  }

  static void processRequest(Socket clientSocket) {
    try (
        // 요청 처리가 끝난 후 클라이언트와 연결된 소켓을 자동으로 닫으려면
        // 이 괄호 안에 별도의 로컬 변수에 담는다.
        // 바로clientSocket을 파라미터로 받아서 쓰면 자동으로 닫을 수 없기때문에!
        // 괄호 안에 선언된것만 자동으로 닫는다.
        Socket socket = clientSocket;

        // 클라이언트의 메시지를 수신하고 클라이언트로 전송할 입출력 도구 준비
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream())) {

      System.out.println("통신을 위한 입출력 스트림을 준비하였음!");

      // 클라이언트가 보낸 메시지를 수신한다.
      // => 한 줄의 메시지를 읽을 때까지 리턴하지 않는다.
      String message = in.nextLine(); // 메시지를 읽는다.
      System.out.println("클라이언트가 보낸 메시지를 수신하였음!");

      System.out.println("클라이언트: " + message);
      // 클라이언트에게 메시지를 전송한다.
      // => 클라이언트가 메시지를 모두 읽을 때 까지 리턴하지 않는다.
      out.println("Hi(지윤쓰)");
      System.out.println("클라이언트로 메시지를 전송하였음!");

    } catch (Exception e) {
      System.out.println("예외 발생: ");
      e.printStackTrace();
    }
  }
}
