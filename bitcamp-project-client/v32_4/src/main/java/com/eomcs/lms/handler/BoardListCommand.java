
package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Board;

// "/board/list" 명령 처리
public class BoardListCommand implements Command {

  // 의존객체
  ObjectOutputStream out;
  ObjectInputStream in;

  public BoardListCommand(ObjectOutputStream out, ObjectInputStream in) {
    // 서버와 응답
    this.out = out;
    this.in = in;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void execute() {

    try {
      out.writeUTF("/board/list"); // 서버에 요청!
      // 서버에 데이터를 즉시 전송하도록 임시 버퍼에 저장된 내용을 내보낸다.
      out.flush();
      // 기존에 println()을 호출할 때는 flush()를 따로 호출하지 않았는데
      // 왜 writeUTF()를 사용하여 데이터를 보낼 때는 flush()를 따로 호출해야 하는가?
      // => println()을 호출할 때는 데이터 뒤에 줄바꿈 코드가 붙는다.
      //    줄바꿈 코드가 있으면 출력 스트림은 자동으로 flush()를 수행한다.
      // => 그러면 NIC(랜카드) 버퍼에 보관된 데이터가 전송된다.
      // => 그러나 writeUTF()의 경우는 flush()가 자동으로 수행되지 않는다.
      //    그래서 데이터를 즉시 전송하고 싶다면 개발자가 명시적으로 flush()를 호출해야 한다.
      
      // 참고!
      // close()를 호출해도 자동으로 flush()가 수행된다.
      // flush()를 호출하지 않으면 버퍼에 쌓여 서버에 내용을 내보내지 않는다.

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF()); // 서버의 메시지(왜 실패했는지)를 읽는다.
        return;
      }

      List<Board> boards = (List<Board>) in.readObject(); // 보내준 리스트를 읽는다.
      for (Board b : boards) {
        System.out.printf("%d, %s, %s, %d\n", b.getNo(), b.getTitle(), b.getDate(),
            b.getViewCount());
      }

    } catch (Exception e) {
      System.out.println("통신 오류 발생!");

    }
  }



}
