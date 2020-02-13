package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardObjectFileDao extends AbstractObjectFileDao<Board> implements BoardDao {


  public BoardObjectFileDao(String filename) {
    super(filename);
  }

  // 서블릿 객체들이 데이터를 다룰 때 사용할 메서드를 정의한다.
  @Override
  public int insert(Board board) throws Exception {

    if (indexOf(board.getNo()) > -1) { // 클라이언트가 보낸 번호가 같은 번호의 게시물이 있다면
      return 0; // 0개 저장
    }

    list.add(board); // 파라미터로 넘어온 번호를 새 게시물로 등록(저장)한다.
    saveData();
    return 1;
  }

  @Override
  public List<Board> findAll() throws Exception {
    return list;
  }

  @Override
  public Board findByNo(int no) throws Exception {
    int index = indexOf(no);
    if (index == -1) {
      return null;
    }
    return list.get(index); // 인덱스의 게시물을 꺼내서 리턴.
  }

  @Override
  public int update(Board board) throws Exception {
    int index = indexOf(board.getNo());

    if (index == -1) {
      return 0; // 못찾으면
    }
    list.set(index, board); // 기존 객체를 파라미터로 받은 객체로 바꾼다.
    saveData();
    return 1;
  }

  @Override
  public int delete(int no) throws Exception {

    int index = indexOf(no);
    if (index == -1) {
      return 0;
    }

    list.remove(index);
    saveData(); // 기존 파일에 덮어씌어서 저장
    return 1;
  }

  // 추상클래스 오버라이딩
  @Override
  protected <K> int indexOf(K key) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == (int) key) {
        // K가 어떤 타입(int 등)인지 형변환(타입캐스딩)해서 사용하라! (명시해주기!)
        // 같은 번호가 있는지 없는지 확인
        return i; // 같은 번호라면 그 번호를 리턴.
      }
    }
    return -1;
  }
}
