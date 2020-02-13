package com.eomcs.lms.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberObjectFileDao {

  String filename;
  List<Member> list;

  public MemberObjectFileDao(String filename) {
    this.filename = filename;
    list = new ArrayList<>();
    loadData(); // 객체가 생성될 때 데이터 로딩
  }

  @SuppressWarnings("unchecked")
  private void loadData() {
    File file = new File(filename);

    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {

      list = (List<Member>) in.readObject();
      System.out.printf("총 %d 개의 회원 데이터를 로딩했습니다.\n", list.size());

    } catch (Exception e) {
      // 모든 예외를 다 받는다
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());

    }
  }


  private void saveData() {
    File file = new File(filename);

    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {

      out.reset(); // 기존의 직렬화(Serialize)수행 중에 캐시된(임시보관된) 데이터를 초기화 시킨다.
      out.writeObject(list);

      System.out.printf("총 %d 개의 회원 데이터를 저장했습니다.\n", list.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

    }
  }

  // 서블릿 객체들이 데이터를 다룰 때 사용할 메서드를 정의한다.
  public int insert(Member member) throws Exception {

    if (indexOf(member.getNo()) > -1) { // 클라이언트가 보낸 번호가 같은 번호의 게시물이 있다면
      return 0; // 0개 저장
    }

    list.add(member); // 파라미터로 넘어온 번호를 새 게시물로 등록(저장)한다.
    saveData();
    return 1;
  }

  public List<Member> findAll() throws Exception {
    return list;
  }

  public Member findByNo(int no) throws Exception {
    int index = indexOf(no);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  public int update(Member member) throws Exception {

    int index = indexOf(member.getNo());

    if (index == -1) {
      return 0;
    }
    list.set(index, member); // 기존 객체를 파라미터로 받은 객체로 바꾼다.
    saveData();
    return 1;
  }

  public int delete(int no) throws Exception {

    int index = indexOf(no);

    if (index == -1) {
      return 0;
    }
    list.remove(index);
    saveData(); // 기존 파일에 덮어씌어서 저장
    return 1;
  }

  private int indexOf(int no) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }

}