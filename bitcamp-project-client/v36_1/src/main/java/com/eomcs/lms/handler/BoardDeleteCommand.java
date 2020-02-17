
package com.eomcs.lms.handler;

import com.eomcs.lms.dao.BoardDao;
import com.eomcs.util.Prompt;

// "/board/delete" 명령 처리
public class BoardDeleteCommand implements Command {

  Prompt prompt;
  BoardDao boardDao;

  public BoardDeleteCommand(BoardDao boardDao, Prompt prompt) {
    // 프록시 객체가 넘어올 것이다.
    this.boardDao = boardDao;
    this.prompt = prompt;
  }


  @Override
  public void execute() {

    try {
      int no = prompt.inputInt("번호? ");

      // 리턴값이 있을지 없을지는 호출한 쪽에서 알아서 처리하도록
      if (boardDao.delete(no) > 0) {
        System.out.println("게시글을 삭제했습니다.");

      } else {
        System.out.println("해당 번호의 게시글이 없습니다.");
      }

    } catch (Exception e) {
      System.out.println("삭제 실패!");
    }
  }
}
