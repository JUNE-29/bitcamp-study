/* order by */

/* 기본 인덱스 컬럼을 기준으로 정렬한다.*/
select rno, loc, name 
from room;

/* 이름의 오름 차순으로 정렬하기 */
select rno, loc, name 
from room
order by name asc;

/* asc는 생략 가능하다. */
select rno, loc, name 
from room
order by name;

/* 이름의 내림 차순으로 정렬하기 */
select rno, loc, name 
from room
order by name desc;

/* 이름은 오름차순, 지점명도 오름차순으로 정렬하기*/
select rno, loc, name 
from room
order by name asc, loc asc;
---> 이름부터 먼저 정렬하고 그 다음에 이름에 맞게 지점 정렬

/* 이름은 오름차순, 지점명은 내림차순으로 정렬하기*/
select rno, loc, name 
from room
order by name asc, loc desc;

/* 지점명은 오름차순으로, 이름은 오름차순  정렬하기*/
select rno, loc, name 
from room
order by loc asc, name asc;
---> 지점부터 먼저 정렬하고 그 다음에 지점에 맞게 이름 정렬











