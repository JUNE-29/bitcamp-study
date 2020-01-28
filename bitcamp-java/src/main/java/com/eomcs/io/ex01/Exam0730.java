// 활용 - 지정한 폴더에서 .class 파일만 찾아 출력하라.
package com.eomcs.io.ex01;

import java.io.File;
import java.io.FileFilter;

public class Exam0730 {


  public static void main(String[] args) throws Exception {

    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printList(dir);

  }

  static void printList(File dir) {

    // 현재 디렉토리의 하위 파일 및 디렉토리 목록을 알아낸다.
    File[] files = dir.listFiles(new FileFilter() {

      @Override
      public boolean accept(File pathname) {
        if (pathname.isHidden()) {
          // 감춤 파일은 포함시키지 말자.
          return false;
        }

        if (pathname.getName().contains("$")) {
          // 중첩클래스를 거르기 위해 "$"가 포함된것은 포함시키지 말자.
          return false;
        }

        if (pathname.isDirectory()
            || (pathname.isFile() && pathname.getName().endsWith(".class"))) {
          return true;
        }
        return false;
      }
    });

    // 리턴 받은 파일 배열에서 이름을 꺼내 출력한다.
    for (File file : files) {
      if (file.isDirectory()) {
        // 디렉토리인 경우 출력하지 않기
        printList(file);
      } else {
        // 파일인 경우 출력
        System.out.printf("%s\n", file.getName());
      }
    }
  }
}


