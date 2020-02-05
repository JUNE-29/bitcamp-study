package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberAddServlet implements Servlet {

  List<Member> members;

  public MemberAddServlet(List<Member> members) {
    this.members = members;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {

    Member member = (Member) in.readObject();

    int i = 0;
    for (; i < members.size(); i++) {
      if (members.get(i).getNo() == member.getNo()) {
        break;
      }
    }

    if (i == members.size()) { // 같은 번호의 게시물이 없다면
      members.add(member); // 새 게시물을 등록한다.
      out.writeUTF("OK"); // 잘 저장했다고 응답

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("같은 번호의 게시물이 있습니다.");
    }
  }
}
