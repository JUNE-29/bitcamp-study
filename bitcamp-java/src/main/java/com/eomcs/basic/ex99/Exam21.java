 package com.eomcs.basic.ex99;

 public class Exam21 {
   public static void main(String[] args){
    // 키보드 정보를 가져온다.
     java.io.InputStream keyboard = System.in; 
     
     // 키보드 객체에 정수, 부동소수점, 논리값, 문자열을 끊어서 읽어 주는
     // 도우미 객체를 붙인다. 
     //in 에 커서를 갖다대면 무슨 타입인지 나오니 변수를 만들어 주고 system.in 을 넣어주면 된다
     //ex) java.io.PrintStream console = System.out;

     //Scanner가 데이터를 읽을때 keyboard 에서 들어오는 데이터를 갖고 가공을 한다. 마치 샤워기 헤드처럼..
     java.util.Scanner scanner = new java.util.Scanner(keyboard);
    
     // 키보드로부터 들어온 바이트 배열을 분석하여
     // 줄 바꿈 기호(엔터 Enter)를 만나면 그 앞에 입력한 바이트 배열을 
     // 문자열로 변환하여 리턴한다. 
     // 키보드로부터 줄바꿈 값이 들어오지 않으면 영원히 리턴하지 않는다.
     String s1 = scanner.nextLine();

     String s2 = scanner.nextLine();

     String s3 = scanner.nextLine();
     
     System.out.println("------------------------------");

     System.out.println(s1);
     System.out.println(s2);
     System.out.println(s3);

     

   }
 }

