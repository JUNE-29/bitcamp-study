// LMS 클라이언트
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.util.Prompt;

public class ClientApp {

  Scanner keyboard = new Scanner(System.in);
  Prompt prompt = new Prompt(keyboard);

  public void service() {

    String serverAddr = null;
    int port = 0;


    try {

      // 사용자로부터 접속할 서버의 주소와 포트 번호를 입력 받는다.
      serverAddr = prompt.inputString("서버? ");
      port = prompt.inputInt("포트? ");

    } catch (Exception e) {
      System.out.println("서버 주소 또는 포트 번호가 유효하지 않습니다!");
      keyboard.close();
      return;
    }


    try (
        // 서버와 연결
        Socket socket = new Socket(serverAddr, port);

        // 소켓을 통해 데이터를 읽고 쓰는 도구를 준비한다.
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      System.out.println("서버와 연결되었음!");

      processCommand(out, in);

      System.out.println("서버와 연결을 끊었음!");

    } catch (Exception e) {
      System.out.println("예외 발생");
      e.printStackTrace(); // 예외가 왜 발생했는지 거꾸로 다 출력해준다.
    }

    keyboard.close();
  }

  private void processCommand(ObjectOutputStream out, ObjectInputStream in) {

    // 사용자 명령을 처리하는

    Deque<String> commandStack = new ArrayDeque<>();
    Queue<String> commandQueue = new LinkedList<>();

    HashMap<String, Command> commandMap = new HashMap<>();
    commandMap.put("/board/list", new BoardListCommand(out, in));
    commandMap.put("/board/add", new BoardAddCommand(out, in, prompt));
    commandMap.put("/board/detail", new BoardDetailCommand(out, in, prompt));
    commandMap.put("/board/update", new BoardUpdateCommand(out, in, prompt));
    commandMap.put("/board/delete", new BoardDeleteCommand(out, in, prompt));

    commandMap.put("/lesson/list", new LessonListCommand(out, in));
    commandMap.put("/lesson/add", new LessonAddCommand(out, in, prompt));
    commandMap.put("/lesson/detail", new LessonDetailCommand(out, in, prompt));
    // 바로 출력할 수 없으니 서버에게 데이터를 요청해야한다.

    try {
      while (true) {
        String command;
        command = prompt.inputString("\n명령> ");

        if (command.length() == 0)
          continue;

        if (command.equals("quit") || command.equals("/server/stop")) {
          out.writeUTF(command);
          out.flush();
          System.out.println("서버: " + in.readUTF());
          System.out.println("안녕!");
          break;
        } else if (command.equals("history")) {
          printCommandHistory(commandStack.iterator());
          continue;
        } else if (command.equals("history2")) {
          printCommandHistory(commandQueue.iterator());
          continue;
        }

        commandStack.push(command);

        commandQueue.offer(command);

        Command commandHandler = commandMap.get(command);

        if (commandHandler != null) {
          try {
            commandHandler.execute();
          } catch (Exception e) {
            System.out.printf("명령어 실행중 오류 발생: %s \n", e.getMessage());
          }
        } else {
          System.out.println("실행할 수 없는 명령입니다.");
        }
      }
    } catch (Exception e) {
      System.out.println("프로그램 실행 중 오류 발생!");
    }

    keyboard.close();
  }

  private void printCommandHistory(Iterator<String> iterator) {
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      count++;

      if ((count % 5) == 0) {
        String str = prompt.inputString(":");
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }



  public static void main(String[] args) throws Exception {
    System.out.println("클라이언트 수업 관리 시스템입니다.");

    ClientApp app = new ClientApp();
    app.service();



  }
}
