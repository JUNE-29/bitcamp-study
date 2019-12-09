package com.eomcs.basic.ex03;


public class Exam22 {
  public static void main(String[] args) {
    // 10진수 리터럴
    System.out.println(2_3500_0000);  //우리나라식
    System.out.println(235_000_000); //서양식
    System.out.println(23_5_0_0_0_000);
    //System.out.println(_23_5_0_0_0_000); 앞에 언더바 안돼
    //System.out.println(23_5_0_0_0_000_); 뒤에 언더바 안돼

    // 8진수 리터럴
    System.out.println(01_44);
    System.out.println(0_144);
    //System.out.println(0144_); 안돼
    //System.out.println(_0144); 안돼

    // 2진수
    System.out.println(0b0110_0100);
    //System.out.println(0b_01100100); 안돼
    //System.out.println(0b01100100_); 안돼
   //System.out.println(0b_01100100); 안돼

    //16진수
    System.out.println(0x0064);
    //System.out.println(0x_0064); 안돼
    //System.out.println(0x0064_); 안돼
    //System.out.println(_0x0064); 안돼
  }
}