package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonObjectFileDao extends AbstractObjectFileDao<Lesson> implements LessonDao {


  public LessonObjectFileDao(String filename) {
    super(filename);
  }


  // 서블릿 객체들이 데이터를 다룰 때 사용할 메서드를 정의한다.
  @Override
  public int insert(Lesson lesson) throws Exception {

    if (indexOf(lesson.getNo()) > -1) { // 클라이언트가 보낸 번호가 같은 번호의 게시물이 있다면
      return 0; // 0개 저장
    }

    list.add(lesson); // 파라미터로 넘어온 번호를 새 게시물로 등록(저장)한다.
    saveData();
    return 1;
  }

  @Override
  public List<Lesson> findAll() throws Exception {
    return list;
  }

  @Override
  public Lesson findByNo(int no) throws Exception {

    int index = indexOf(no);
    if (index == -1) {
      return null;
    }
    return list.get(index); // 인덱스의 게시물을 꺼내서 리턴.
  }

  @Override
  public int update(Lesson lesson) throws Exception {
    int index = indexOf(lesson.getNo());

    if (index == -1) {
      return 0; // 못찾으면
    }

    list.set(index, lesson);
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
    saveData();
    return 1;
  }

  @Override
  protected <K> int indexOf(K key) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == (int) key) {
        return i;
      }
    }
    return -1;
  }
}
