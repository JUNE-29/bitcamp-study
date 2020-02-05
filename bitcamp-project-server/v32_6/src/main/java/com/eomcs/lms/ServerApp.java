// LMS 서버
package com.eomcs.lms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.servlet.BoardAddServlet;
import com.eomcs.lms.servlet.BoardDeleteServlet;
import com.eomcs.lms.servlet.BoardDetailServlet;
import com.eomcs.lms.servlet.BoardListServlet;
import com.eomcs.lms.servlet.BoardUpdateServlet;
import com.eomcs.lms.servlet.LessonAddServlet;
import com.eomcs.lms.servlet.LessonDeleteServlet;
import com.eomcs.lms.servlet.LessonDetailServlet;
import com.eomcs.lms.servlet.LessonListServlet;
import com.eomcs.lms.servlet.LessonUpdateServlet;
import com.eomcs.lms.servlet.MemberAddServlet;
import com.eomcs.lms.servlet.MemberDeleteServlet;
import com.eomcs.lms.servlet.MemberDetailServlet;
import com.eomcs.lms.servlet.MemberListServlet;
import com.eomcs.lms.servlet.MemberUpdateServlet;
import com.eomcs.lms.servlet.Servlet;

public class ServerApp {

  // 옵저버 관련 코드
  // 옵저버 목록을 관리할 객체 준비
  Set<ApplicationContextListener> listeners = new HashSet<>();

  // 옵저버와 공유할 값을 보관할 객체를 준비한다. (옵저버 사이에 데이터를 주고받는 것)
  Map<String, Object> context = new HashMap<>();

  // 커맨드(예: Servlet 구현체) 디자인 패턴과 관련된 코드
  Map<String, Servlet> servletMap = new HashMap<>();


  List<Board> boards;
  List<Member> members;
  List<Lesson> lessons;

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


  @SuppressWarnings("unchecked")
  public void service() {

    // 애플리케이션이 시작되면 등록된 옵저버를 실행한다.
    // 즉 DataLoaderListener를 실행한다!
    notifyApplicationInitialized();

    // DataLoaderListener가 준비한 데이터(인스턴스주소)를 꺼내 인스턴스 필드에 저장한다.
    boards = (List<Board>) context.get("boardList");
    members = (List<Member>) context.get("memberList");
    lessons = (List<Lesson>) context.get("lessonList");

    // 커멘드 객체 역할을 수행하는 서블릿 객체를 맵에 보관한다.
    servletMap.put("/board/list", new BoardListServlet(boards));
    servletMap.put("/board/add", new BoardAddServlet(boards));
    servletMap.put("/board/detail", new BoardDetailServlet(boards));
    servletMap.put("/board/update", new BoardUpdateServlet(boards));
    servletMap.put("/board/delete", new BoardDeleteServlet(boards));

    servletMap.put("/lesson/list", new LessonListServlet(lessons));
    servletMap.put("/lesson/add", new LessonAddServlet(lessons));
    servletMap.put("/lesson/detail", new LessonDetailServlet(lessons));
    servletMap.put("/lesson/update", new LessonUpdateServlet(lessons));
    servletMap.put("/lesson/delete", new LessonDeleteServlet(lessons));

    servletMap.put("/member/list", new MemberListServlet(members));
    servletMap.put("/member/add", new MemberAddServlet(members));
    servletMap.put("/member/detail", new MemberDetailServlet(members));
    servletMap.put("/member/update", new MemberUpdateServlet(members));
    servletMap.put("/member/delete", new MemberDeleteServlet(members));



    try (
        // 서버쪽 연결 준비
        // => 클라이언트의 연결을 9999번 포트에서 기다린다. ex) 병원대기실
        ServerSocket serverSocket = new ServerSocket(9999);) {

      System.out.println("클라이언트 연결 대기중....");

      while (true) {

        // 서버에 대기하고 있는 클라이언트와 연결, Stack 방식으로 연결.
        Socket socket = serverSocket.accept();
        System.out.println("클라이언트와 연결되었음!");

        // 클라이언트의 요청 처리
        if (processRequest(socket) == 9) {
          break; // 서버를 Stop 시키기 위해서
        }

        System.out.println("------------------요청처리 끝--------------------");
      }


    } catch (Exception e) {
      System.out.println("서버 준비 중 오류 발생!");
    }

    notifyApplicationDestroyed();

  } // service()


  int processRequest(Socket clientSocket) {

    try (Socket socket = clientSocket;
        // 클라이언트의 메시지를 수신하고 클라이언트로 전송할 입출력 도구 준비
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

      System.out.println("통신을 위한 입출력 스트림을 준비하였음!");

      while (true) {
        String request = in.readUTF(); // 요청 메시지를 읽는다.
        System.out.println("클라이언트가 보낸 메시지를 수신하였음!");

        // 클라이언트의 명령에 응답을 한다.
        switch (request) {
          case "quit":
            quit(out);
            return 0; // 클라이언트와 연결을 끊는다.
          case "/server/stop":
            quit(out);
            return 9; // 서버를 종료한다.
        }

        // 클라이언트의 요청을 처리할 객체를 찾는다.
        Servlet servlet = servletMap.get(request);

        if (servlet != null) { // 없다면 간단한 안내 메시지로 응답한다.
          // 클라이언트 요청을 처리할 객체를 찾았으면 작업을 실행시킨다.
          try {

            servlet.service(in, out);

          } catch (Exception e) {
            // 요청한 작업을 수행하다가 오류 발생할 경우 그 이유를 응답한다.
            out.writeUTF("FAIL");
            out.writeUTF(e.getMessage());

            // 서버쪽 화면에는 더 자세하게 오류 내용을 출력한다.
            System.out.println("클라이언트 요청 처리 중 오류 발생:");
            e.printStackTrace();
          }
        } else {// 없다면? 간단한 안내 메시지로 응답한다.
          notFound(out);

        }

        out.flush();
        System.out.println("클라이언트에게 응답하였음!");
        System.out.println("--------------------------------------------------");
      }

    } catch (Exception e) {
      System.out.println("예외 발생: ");
      e.printStackTrace();
      return -1;
    }
  } // processRequest()

  private void notFound(ObjectOutputStream out) throws IOException {
    out.writeUTF("FAIL");
    out.writeUTF("요청한 명령을 처리할 수 없습니다.");
  }


  private void quit(ObjectOutputStream out) throws IOException {
    out.writeUTF("OK");
    out.flush();
  }

  public static void main(String[] args) {
    System.out.println("서버 수업 관리 시스템입니다.");

    ServerApp app = new ServerApp();

    app.addApplicationContextListener(new DataLoaderListener());
    app.service();

  }
}
