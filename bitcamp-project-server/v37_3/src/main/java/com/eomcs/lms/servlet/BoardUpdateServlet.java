package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardUpdateServlet implements Servlet {

  // DAO 클래스를 구체적으로 지정하기 보다는
  // 인터페이스를 지정함으로써
  // 향후 다른 구현체로 교체하기 쉽도록 한다.

  BoardDao boardDao;

  public BoardUpdateServlet(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    // 예외를 호출한 쪽으로 던진다.

    out.println("번호? ");
    out.println("!{}!");
    out.flush();
    int no = Integer.parseInt(in.nextLine());

    Board old = boardDao.findByNo(no);
    if (old == null) {
      out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    out.printf("제목(%s)? \n", old.getTitle());
    out.println("!{}!");
    out.flush();
    Board board = new Board();
    board.setTitle(in.nextLine());
    board.setNo(no);

    if (boardDao.update(board) > 0) { // 변경했다면
      out.println("게시글을 변경했습니다.");
    } else {
      out.println("게시글 변경에 실패했습니다.");
    }
  }
}
