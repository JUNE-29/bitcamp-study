package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberUpdateCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;

  public Prompt prompt;

  public MemberUpdateCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }


  @Override
  public void execute() {

    try {
      int no = prompt.inputInt("번호? ");

      out.writeUTF("/member/detail");
      out.writeInt(no);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }


      Member oldMember = (Member) in.readObject();
      Member newMember = new Member();

      newMember.setNo(oldMember.getNo());
      newMember.setName(
          prompt.inputString(String.format("이름(%s)? ", oldMember.getName()), oldMember.getName()));
      newMember.setEmail(prompt.inputString(String.format("이메일(%s)? ", oldMember.getEmail()),
          oldMember.getEmail()));
      newMember.setPassword(prompt.inputString(String.format("이메일(%s)? ", oldMember.getPassword()),
          oldMember.getPassword()));
      newMember.setPhoto(prompt.inputString(String.format("사진(%s)? ", oldMember.getPhoto()),
          oldMember.getPhoto()));
      newMember.setTel(
          prompt.inputString(String.format("사진(%s)? ", oldMember.getTel()), oldMember.getTel()));
      newMember.setRegisteredDate(new Date(System.currentTimeMillis()));

      if (oldMember.equals(newMember)) {
        System.out.println("회원정보 변경을 취소했습니다.");
        return;
      }

      out.writeUTF("/member/update");
      out.writeObject(newMember);
      out.flush();

      response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }

      System.out.println("회원정보를 변경했습니다.");

    } catch (Exception e) {
      System.out.println("통신 오류 발생!");
    }

  }

}