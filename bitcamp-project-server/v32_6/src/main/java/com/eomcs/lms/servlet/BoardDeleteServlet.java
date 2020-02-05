package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardDeleteServlet implements Servlet {

  List<Board> boards;

  public BoardDeleteServlet(List<Board> boards) {
    this.boards = boards;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    // 예외를 호출한 쪽으로 던진다.

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
  }
}
