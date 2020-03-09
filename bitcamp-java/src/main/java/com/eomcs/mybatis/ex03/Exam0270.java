// dynamic sql 다루기 - <foreach> 사용법III
package com.eomcs.mybatis.ex03;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0270 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream =
        Resources.getResourceAsStream("com/eomcs/mybatis/ex03/mybatis-config.xml");
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    HashMap<String, Object> params = new HashMap<>();

    Scanner keyScan = new Scanner(System.in);

    System.out.print("검색? ");
    String[] values = keyScan.nextLine().split(" ");

    ArrayList<Object> words = new ArrayList<>();
    for (String value : values) {
      words.add(value.trim()); // trim() : 양쪽의 공백을 없애는 것
    }
    params.put("words", words);

    keyScan.close();

    List<Board> list = sqlSession.selectList("BoardMapper.select25", params);

    for (Board board : list) {
      System.out.printf("%d, %s, %s, %s, %d\n", //
          board.getNo(), //
          board.getTitle(), //
          board.getContent(), //
          board.getRegisteredDate(), //
          board.getViewCount());
    }
    // 데이터를 조회하는 경우는 commit 할 필요가 없다.
    sqlSession.close();
  }

}


