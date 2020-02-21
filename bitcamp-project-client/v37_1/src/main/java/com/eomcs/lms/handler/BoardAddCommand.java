
package com.eomcs.lms.handler;

import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Prompt;

// "/board/add" 명령어 처리
public class BoardAddCommand implements Command {

  Prompt prompt;
  BoardDao boardDao;

  public BoardAddCommand(BoardDao boardDao, Prompt prompt) {
    // 프록시 객체가 넘어올 것이다.
    this.boardDao = boardDao;
    this.prompt = prompt;
  }


  @Override
  public void execute() {

    Board board = new Board();
    board.setTitle(prompt.inputString("내용? "));

    try {
      boardDao.insert(board);
      System.out.println("저장하였습니다.");

    } catch (Exception e) {
      System.out.println("저장 실패!");
    }
  }
}
