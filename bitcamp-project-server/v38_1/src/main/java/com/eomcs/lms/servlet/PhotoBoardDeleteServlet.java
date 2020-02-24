package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.PhotoBoardDao;

public class PhotoBoardDeleteServlet implements Servlet {


  PhotoBoardDao photoBoardDao;

  public PhotoBoardDeleteServlet(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    // 예외를 호출한 쪽으로 던진다.

    out.println("번호? ");
    out.println("!{}!");
    out.flush();

    int no = Integer.parseInt(in.nextLine()); // 읽는다.

    if (photoBoardDao.delete(no) > 0) { // 삭제하려는 번호의 게시물을 찾고 삭제했다면
      out.println("사진 게시글을 삭제했습니다.");

    } else {
      out.println("해당 번호의 사진 게시글이 없습니다.");
    }
  }
}
