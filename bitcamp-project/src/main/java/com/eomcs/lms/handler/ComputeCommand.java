// "/board/add" 명령어 처리

package com.eomcs.lms.handler;

import com.eomcs.util.Prompt;

public class ComputeCommand implements Command {

  Prompt prompt;

  public ComputeCommand(Prompt prompt) {
    this.prompt = prompt;
  }


  @Override
  public void execute() {
    int i1 = prompt.inputInt("수1 ? ");
    int i2 = prompt.inputInt("수2 ? ");
    int compute = i1 + i2;

    System.out.printf("계산결과는 %d 입니다.\n", compute);

  }



}
