package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardAddServlet implements Servlet {

  // DAO 클래스를 구체적으로 지정하기 보다는
  // 인터페이스를 지정함으로써
  // 향후 다른 구현체로 교체하기 쉽도록 한다.

  BoardDao boardDao;

  public BoardAddServlet(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    // 예외를 호출한 쪽으로 던진다.

    Board board = new Board();

    board.setTitle(Prompt.getString(in, out, "제목? ")); // 클라이언트가 보낸 것을 읽는다. 그리고 보드에 저장.

    if (boardDao.insert(board) > 0) { // 등록(저장)했다면
      out.println("새 게시글을 등록했습니다."); // 잘 저장했다고 클라이언트에게 응답

    } else {
      out.println("게시글 등록에 실패했습니다.");
    }
  }
}
