// 활용 - 클래스 파일 이름을 출력할 때 패키지 이름을 포함하라.
package com.eomcs.io.ex01;

import java.io.File;
import java.io.FileFilter;

public class Exam0731 {


  public static void main(String[] args) throws Exception {

    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printList(dir, "");

  }

  static void printList(File dir, String packageName) {

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

    if (packageName.length() > 0) {
      // 패키지 이름이 단 한자라도 존재한다면 "."을 붙여라
      packageName += ".";
    }
    // 리턴 받은 파일 배열에서 이름을 꺼내 출력한다.
    for (File file : files) {
      if (file.isDirectory()) {
        printList(file, packageName + file.getName());
      } else {
        System.out.println(packageName + file.getName().replace(".class", ""));
        // replace(".class",""); .class를 빈 문자열로 바꾸어라
      }
    }
  }
}


