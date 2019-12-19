package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    
    class Member{
      int no;
      String name;
      String email;
      String password;
      String photo;
      String tel;
      Date registeredDate;
    }
    final int SIZE = 100;
    
    Member[] members = new Member[SIZE];
    
    int count = 0;
    
    for (int i = 0; i < SIZE; i++) {
      
      count++;
      
      // 회원정보를 저장할 메모리를 Member 설계도에 따라 만든다.
      // 인스턴스를 만들어줄 준비를 한다.
      // Member -> class / meber -> new Member();를 담아줄 변수.
      // 인스턴스를 만들어 주기 위해 얘기해주는거다. 인스턴스 방 만들기위해.
      Member member = new Member();
      
      System.out.print("번호? ");
      member.no = keyboard.nextInt();
      keyboard.nextLine(); // 줄바꿈 
      
      System.out.print("이름? ");
      member.name = keyboard.nextLine();
      
      System.out.print("이메일? ");
      member.email = keyboard.nextLine();
      
      System.out.print("비밀번호? ");
      member.password = keyboard.nextLine();
      
      System.out.print("사진? ");
      member.photo = keyboard.nextLine();
      
      System.out.print("전화? ");
      member.tel = keyboard.nextLine();
      
      member.registeredDate = new Date(System.currentTimeMillis());
      
      // 회원 정보가 담겨 있는 인스턴스의 주소를 레퍼런스 배열에 보관한다.
      // 인스턴스에 입력받은 것들을 가지고 인스턴스 주소를  members 레퍼런스 배열속에 담는다.
      // 그러니까 한번 입력 했다면 members[1] = member; 인것이다.
      members[i] = member;
      
      System.out.print("계속 입력하시겠습니까?(Y/n)");
      String response = keyboard.nextLine();
      if(!response.equalsIgnoreCase("y")) 
        break;
    }
    keyboard.close();
    
    System.out.println();
    
    // 출력할 때 인스턴스에 입력 되어있던 것들이 members[i]에 인스턴스 주소가 저장이 되어있고
    // members[i]에 있는 ex)members[1], members[2], members[3] .. 등 저장되어있는
    // 인스턴스 주소 -> 각 입력했던 값들을 출력할 수 있는 것이다.
    for(int i = 0; i < count; i++){
      Member member = members[i];
      System.out.printf("%d, %s, %s, %s, %s\n", 
          member.no, member.name, member.email, member.tel, member.registeredDate);
    }
  }
}
