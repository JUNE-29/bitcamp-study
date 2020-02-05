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

public class ServerApp {

  // 옵저버 관련 코드
  // 옵저버 목록을 관리할 객체 준비
  Set<ApplicationContextListener> listeners = new HashSet<>();

  // 옵저버와 공유할 값을 보관할 객체를 준비한다. (옵저버 사이에 데이터를 주고받는 것)
  Map<String, Object> context = new HashMap<>();

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
          case "/board/list":
            listBoard(out);
            break;
          case "/board/add":
            addBoard(in, out);
            break;
          case "/board/detail":
            detailBoard(in, out);
            break;
          case "/board/update":
            updateBoard(in, out);
            break;
          case "/board/delete":
            deleteBoard(in, out);
            break;
          case "/lesson/list":
            listLesson(out);
            break;
          case "/lesson/add":
            addLesson(in, out);
            break;
          case "/lesson/detail":
            detailLesson(in, out);
            break;
          case "/lesson/update":
            updateLesson(in, out);
            break;
          case "/lesson/delete":
            deleteLesson(in, out);
            break;
          case "/member/list":
            listMember(out);
            break;
          case "/member/add":
            addMember(in, out);
            break;
          case "/member/detail":
            detailMember(in, out);
            break;
          case "/member/update":
            updateMember(in, out);
            break;
          case "/member/delete":
            deleteMember(in, out);
            break;
          default:
            notFound(out);
        }
        out.flush();
        System.out.println("클라이언트에게 응답하였음!");
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

  private void deleteMember(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      int no = in.readInt();

      int index = -1;
      for (int i = 0; i < members.size(); i++) {
        if (members.get(i).getNo() == no) {
          // 게시물 번호 찾기.
          index = i;
          break;
        }
      }

      if (index != -1) { // 삭제하려는 번호의 게시물을 찾았다면
        members.remove(index); // 삭제
        out.writeUTF("OK");

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 게시물이 없습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }

  private void updateMember(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      Member member = (Member) in.readObject();

      int index = -1;
      for (int i = 0; i < members.size(); i++) {
        if (members.get(i).getNo() == member.getNo()) {
          // 게시물 번호 찾기.
          index = i;
          break;
        }
      }

      if (index != -1) {
        members.set(index, member);
        out.writeUTF("OK");
      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 게시물이 없습니다.");
      }

    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage()); // 왜 오류가 났는지 메세지를 보낸다.
    }
  }

  private void detailMember(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      int no = in.readInt();

      Member member = null;
      for (Member m : members) {
        if (m.getNo() == no) {
          member = m;
          break;
        }
      }

      if (member != null) {
        out.writeUTF("OK");
        out.writeObject(member);
      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 게시물이 없습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }

  private void addMember(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      Member member = (Member) in.readObject();

      int i = 0;
      for (; i < members.size(); i++) {
        if (members.get(i).getNo() == member.getNo()) {
          break;
        }
      }

      if (i == members.size()) { // 같은 번호의 게시물이 없다면
        members.add(member); // 새 게시물을 등록한다.
        out.writeUTF("OK"); // 잘 저장했다고 응답

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("같은 번호의 게시물이 있습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage()); // 왜 오류가 났는지 메세지를 보낸다.
    }
  }

  private void listMember(ObjectOutputStream out) throws IOException {
    out.writeUTF("OK");
    out.reset();
    out.writeObject(members);
  }

  private void deleteLesson(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {

      int no = in.readInt();

      int index = -1;
      for (int i = 0; i < lessons.size(); i++) {
        if (lessons.get(i).getNo() == no) {
          // 게시물 번호가 사용자가 보낸 번호와 같다면
          index = i;
          break;
        }
      }

      if (index != -1) { // 삭제하려는 번호의 게시물을 찾았다면
        lessons.remove(index); // 삭제
        out.writeUTF("OK");

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 게시물이 없습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }

  private void updateLesson(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      Lesson lesson = (Lesson) in.readObject();

      int index = -1;
      for (int i = 0; i < lessons.size(); i++) {
        if (lessons.get(i).getNo() == lesson.getNo()) {
          // 게시물 번호 찾기.
          index = i;
          break;
        }
      }

      if (index != -1) {
        lessons.set(index, lesson);
        out.writeUTF("OK");
      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 게시물이 없습니다.");
      }

    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage()); // 왜 오류가 났는지 메세지를 보낸다.
    }
  }

  private void detailLesson(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      int no = in.readInt();

      Lesson lesson = null;
      for (Lesson l : lessons) {
        if (l.getNo() == no) {
          lesson = l;
          break;
        }
      }

      if (lesson != null) {
        out.writeUTF("OK");
        out.writeObject(lesson);
      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 게시물이 없습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }

  private void addLesson(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      Lesson lesson = (Lesson) in.readObject(); // 객체를 한번 더 읽는다.

      int i = 0;
      for (; i < lessons.size(); i++) {
        if (lessons.get(i).getNo() == lesson.getNo()) {
          break;
        }
      }

      if (i == lessons.size()) { // 같은 번호의 게시물이 없다면
        lessons.add(lesson); // 새 게시물을 등록한다.
        out.writeUTF("OK"); // 잘 저장했다고 응답

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("같은 번호의 게시물이 있습니다.");

      }

    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage()); // 왜 오류가 났는지 메세지를 보낸다.
    }
  }

  private void listLesson(ObjectOutputStream out) throws IOException {
    out.writeUTF("OK");
    out.reset();
    out.writeObject(lessons);
  }

  private void deleteBoard(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {

      int no = in.readInt(); // 객체를 한번 더 읽는다.

      int index = -1;
      for (int i = 0; i < boards.size(); i++) {
        if (boards.get(i).getNo() == no) {
          // 게시물 번호가 사용자가 보낸 번호와 같다면
          index = i;
          break;
        }
      }

      if (index != -1) { // 삭제하려는 번호의 게시물을 찾았다면
        boards.remove(index); // 삭제
        out.writeUTF("OK");

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 게시물이 없습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }

  private void updateBoard(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      Board board = (Board) in.readObject();

      int index = -1;
      for (int i = 0; i < boards.size(); i++) {
        if (boards.get(i).getNo() == board.getNo()) {
          // 게시물 번호 찾기.
          index = i;
          break;
        }
      }

      if (index != -1) {
        boards.set(index, board);
        out.writeUTF("OK");
      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 게시물이 없습니다.");
      }

    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage()); // 왜 오류가 났는지 메세지를 보낸다.
    }
  }

  private void detailBoard(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      int no = in.readInt(); // 객체를 한번 더 읽는다.

      Board board = null;
      for (Board b : boards) {
        if (b.getNo() == no) {
          board = b;
          break;
        }
      }

      if (board != null) {
        out.writeUTF("OK");
        out.writeObject(board);
      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 번호의 게시물이 없습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }

  private void addBoard(ObjectInputStream in, ObjectOutputStream out) throws IOException {
    try {
      Board board = (Board) in.readObject(); // 객체를 한번 더 읽는다.

      int i = 0;
      for (; i < boards.size(); i++) {
        if (boards.get(i).getNo() == board.getNo()) {
          break;
        }
      }

      if (i == boards.size()) { // 같은 번호의 게시물이 없다면
        boards.add(board); // 새 게시물을 등록한다.
        out.writeUTF("OK"); // 잘 저장했다고 응답

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("같은 번호의 게시물이 있습니다.");

      }


    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage()); // 왜 오류가 났는지 메세지를 보낸다.
    }
  }

  private void listBoard(ObjectOutputStream out) throws IOException {
    out.writeUTF("OK");
    out.reset();
    out.writeObject(boards);
  }

  public static void main(String[] args) {
    System.out.println("서버 수업 관리 시스템입니다.");

    ServerApp app = new ServerApp();

    app.addApplicationContextListener(new DataLoaderListener());
    app.service();

  }
}
