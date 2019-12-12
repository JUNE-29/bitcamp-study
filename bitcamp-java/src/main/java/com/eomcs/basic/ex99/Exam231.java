 package com.eomcs.basic.ex99;

 public class Exam231 {
   public static void main(String[] args){
   
    java.util.Scanner scanner = new java.util.Scanner(System.in);

     // nextInt() 다음에 nextLine()을 호출할 때
     // 공백 문자가 읽히는 문제해결
     System.out.print("입력>");
     int i1 = scanner.nextInt(); 
     int i2 = scanner.nextInt();

     // 공백만 그냥 읽는다.
     // next()
     // => 한 개의 token(단어)을 읽는다.
     // => 공백을 만날 때 까지 읽는다.
     // => 앞 공백을 제거한다.
     // => 물론 nextInt()와 달리 값을 읽은 후 뒤의 공백은 제거한다.

     String s1 = scanner.next();
     String s2 = scanner.next();

     int i3 = scanner.nextInt();

     String s3 = scanner.next();

     System.out.println("------------------------------");

     System.out.println(i1);
     System.out.println(i2);
     System.out.println(i3);
     System.out.println(s1);
     System.out.println(s2);
     System.out.println(s3);


     // nextInt()
     // => space(공백), tab, new line을 만나면 그 앞까지 읽은 입력 값을
     //    int 값으로 바꿔 리턴한다.
     // => 현재 커서의 위치는 공백(White space; space/tab/newline 다 포함)에 있다.
     //    즉 값을 읽고 난 후 공백을 제거하지 않는다.
     // => 그래서 다음 메서드는 공백부터 읽게 된다.
     // => nextInt()는 앞에 공백이 있으면 무시한다.
     //    다음 공백을 만날 때까찌 읽는다.
     //
     // 결론
     // => nextInt() 다음에 nextLine()을 실행할 때
     //   nextLine()은 nextInt()가 읽은 값 다음부터 읽기 때문에
     //  기대하지 않은 값이 리턴 될 수 있다.

     // 넥스트 라인은 앞에 공백 뒤에 공백 사이의 토큰을 뽑는다.
     // 커서가 중요. 읽는 위치가 중요.

   }
 }

