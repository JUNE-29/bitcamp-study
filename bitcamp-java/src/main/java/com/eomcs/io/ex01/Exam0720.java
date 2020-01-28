// 활용 - 지정한 폴더를 모두 삭제하라.
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0720 {


  public static void main(String[] args) throws Exception {


    // temp 디렉토리를 삭제하기
    File dir = new File("temp");

    deleteFile(dir);

    System.out.println("삭제하였습니다!");
  }

  static void deleteFile(File dir) {
    File[] files = dir.listFiles();

    for (File file : files) {
      if (file.isDirectory()) {
        deleteFile(file); // 디렉토리를 지운다.
      } else {
        file.delete(); // 파일을 삭제한다.
      }
    }
    dir.delete(); // 자기 자신 삭제.
  }
}


