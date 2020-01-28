// 특정 폴더를 생성하여 그 폴더에 파일을 만든다.
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0431 {

  public static void main(String[] args) throws Exception {
    // 생성할 파일의 경로 설정
    File file = new File("temp/b/test.txt");

    // 파일을 생성하기 전에 존재하지 않는 폴더를 생성하고 싶다면
    // File dir = new File(file.getParent());
    File dir = file.getParentFile(); // 위에 코드와 같다.
    System.out.println(dir.getCanonicalPath());

    if (dir.mkdirs()) {
      System.out.println("디렉토리를 생성하였습니다.");
    } else {
      System.out.println("디렉토리를 생성할 수 없습니다.");
    }

    // 위에서 폴더를 생성한 후에 파일을 생성한다.
    if (file.createNewFile()) { // 파일 생성
      System.out.println("파일을 생성하였습니다.");
    } else {
      System.out.println("파일을 생성할 수 없습니다.");
    }


  }

}
