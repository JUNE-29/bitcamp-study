package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.PhotoBoard;

// 데이터를 저장하고 꺼내는 방식(파일, 클라우드저장소, DB(데이터베이스) 등)에 상관없이
// DAO 사용법을 통일하기 위해
// 메서드 호출 규칙을 정의한다.
//

public interface PhotoBoardDao {

  int insert(PhotoBoard photoBoard) throws Exception;

  List<PhotoBoard> findAllByLessonNo(int lessonNo) throws Exception;

  PhotoBoard findByNo(int no) throws Exception;

  int update(PhotoBoard photoBoard) throws Exception;

  int delete(int no) throws Exception;

}
