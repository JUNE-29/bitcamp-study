package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.json.MemberJsonFileDao;
import com.eomcs.lms.domain.Member;

public class MemberAddServlet implements Servlet {

  MemberJsonFileDao memberDao;

  public MemberAddServlet(MemberJsonFileDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {

    Member member = (Member) in.readObject();


    if (memberDao.insert(member) > 0) { // 같은 번호의 게시물이 없다면
      out.writeUTF("OK"); // 잘 저장했다고 응답

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("같은 번호의 게시물이 있습니다.");
    }
  }
}
