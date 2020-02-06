package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.BoardObjectFileDao;
import com.eomcs.lms.domain.Board;

public class BoardAddServlet implements Servlet {

  BoardObjectFileDao boardDao;

  public BoardAddServlet(BoardObjectFileDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    // 예외를 호출한 쪽으로 던진다.

    Board board = (Board) in.readObject(); // 읽는다.

    if (boardDao.insert(board) > 0) { // 등록(저장)했다면
      out.writeUTF("OK"); // 잘 저장했다고 클라이언트에게 응답

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("같은 번호의 게시물이 있습니다.");
    }
  }
}
