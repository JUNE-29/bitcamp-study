# 06 - 배열과 흐름 제어문 활용하기

## 학습 목표

- 배열을 활용하여 여러 개의 데이터를 저장할 수 있다.
- 조건문과 반복문을 활용하여 프로그램의 실행 흐름을 제어할 수 있다.

## 실습 소스 및 결과

- src/main/java/com/eomcs/lms/App.java 변경
- src/main/java/com/eomcs/lms/App2.java 변경
- src/main/java/com/eomcs/lms/App3.java 변경

## 실습

### 작업1) 읽고싶은 책 내용을 입력 받아 출력하라.

App.java 실행 결과

App.읽고싶은 책 찾기

목록으로 출력할 항목은 `번호, 지은이, 출판사, 출판 년도`이다.

```
번호? 1
도서명? 어떻게 살 것인가
지은이? 유시민
출판사? 생각의 길
카테고리? 인문
출판 년도? 2013년 3월

계속 입력하시겠습니까?(Y/n) y

번호? 2
도서명? 마녀체력
지은이? 이영미
출판사? 남해의 봄
카테고리? 에세이
출판 년도? 2018년 5월

계속 입력하시겠습니까?(Y/n) y

번호? 3
도서명? 여행의 이유
지은이? 김영하
출판사? 문학동네
카테고리? 에세이
출판 년도? 2019년 4월

계속 입력하시겠습니까?(Y/n) n

1, 어떻게 살 것인가  , 유시민 , 2013년 3월, 인문
2, 마녀체력 , 이영미, 2018년 5월, 에세이
3, 여행의 이유, 김영하, 문학동네, 에세이
```

### 작업2) 책 추천 받을 사람의 정보를 입력 받고 출력하라.

App2.java 실행 결과

목록으로 출력할 항목은 `번호, 카테고리, 나이, 성격, 키워드, 입력날짜`이다.

```
번호? 1
카테고리? 인문
국가별(언어)? 한국
나이? 29
MBTI(성격)? INFP
키워드(태그)? 철학, 인생

계속 입력하시겠습니까?(Y/n) y

번호? 2
카테고리? 과학
국가별(언어)? 한국
나이? 30
MBTI(성격)? INFJ
키워드(태그)? 우주, 물리

계속 입력하시겠습니까?(Y/n) y

번호? 3
카테고리? 외국어
국가별(언어)? 한국
나이? 20
MBTI(성격)? ENPJ
키워드(태그)? 토익, 토플

계속 입력하시겠습니까?(Y/n) n

1, 인문 , 29세, INFP , #철학 #인생 , 2019-01-01
2, 과학 , 30세, INFJ, #우주 #물리, 2019-01-01
3, 외국어 , 20세, ENPJ, #토익 #토플, 2019-01-01
```

### 작업3) 내가 읽은 책 리뷰 쓰기. 여러 개의 게시글을 입력 받아 출력하라.

App3.java 실행 결과

목록으로 출력할 항목은 `번호, 도서명, 제목, 책 점수, 작성일, 조회수`이다.

```
번호? 1
도서명? 어떻게 살 것인가
제목? 어떻게 살지 알았다
내용? 보니까 어떻게 살지 감잡음
이미지? bookreview.png
책에 대한 점수(5점만점)? 4.5 점

계속 입력하시겠습니까?(Y/n) y

번호? 2
도서명? 마녀체력
제목? 운동을 시작하자.
내용? 운동 고고
이미지? bookreview.png
책에 대한 점수(5점만점)? 5.0 점

계속 입력하시겠습니까?(Y/n) y

번호? 3
도서명? 여행의 이유
제목? 여행이 고플때
내용? 여행 고고
이미지? bookreview.png
책에 대한 점수(5점만점)? 3.9 점
계속 입력하시겠습니까?(Y/n) n

1, 어떻게 살 것인가, 4.5 점, 2019-01-01, 0
2, 마녀체력, 5.0 점, 2019-01-01, 0
3, 여행의 이유, 3.9 점, 2019-01-01, 0
```
