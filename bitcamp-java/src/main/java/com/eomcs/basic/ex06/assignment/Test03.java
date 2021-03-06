package com.eomcs.basic.ex06.assignment;

// 현재 과제와 가장 유사한 결과를 내는 소스를 가져와서 만든다.
public class Test03 {
  public static void main(String[] args) {

    int width = Console.inputInt();

    if(width % 2 == 0) 
      width--;

    int spaceSize = width >> 1; // = '/2' 나누기 2 와 같다. 
    int line = 0; 
    while(line++ < width) { 
      if(line % 2 == 0) {
        continue;
      }

      Graphic.drawLine(spaceSize, ' ');
      spaceSize--;

      Graphic.drawLine(line, '*');
      System.out.println();
    }
  }
}
