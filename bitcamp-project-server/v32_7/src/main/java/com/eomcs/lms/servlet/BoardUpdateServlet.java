package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.BoardObjectFileDao;
import com.eomcs.lms.domain.Board;

public class BoardUpdateServlet implements Servlet {

  BoardObjectFileDao boardDao;

  public BoardUpdateServlet(BoardObjectFileDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    // 예외를 호출한 쪽으로 던진다.

    Board board = (Board) in.readObject();


    if (boardDao.update(board) > 0) { // 변경했다면
      out.writeUTF("OK");
    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 번호의 게시물이 없습니다.");
    }
  }
}
