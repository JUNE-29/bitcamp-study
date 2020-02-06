package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.BoardObjectFileDao;
import com.eomcs.lms.domain.Board;

public class BoardDetailServlet implements Servlet {

  BoardObjectFileDao boardDao;

  public BoardDetailServlet(BoardObjectFileDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    // 예외를 호출한 쪽으로 던진다.

    int no = in.readInt();

    Board board = boardDao.findByNo(no);
    // Dao에게 번호를 찾아달라고 한다.

    if (board != null) {
      out.writeUTF("OK");
      out.writeObject(board);
    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 번호의 게시물이 없습니다.");
    }
  }
}
