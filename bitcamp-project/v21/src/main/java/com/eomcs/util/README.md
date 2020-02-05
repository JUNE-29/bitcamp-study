# Stack 만들기

- 1) 최소 클래스를 작성한다.
- 2) 데이터를 저장할 레퍼런스 배열과 상수 필드를 준비한다.
- 3) 레퍼런스 배열을 초기화 시키는 생성자를 만든다.
- 4) push() 추가
- 5) push() 변경: 배열이 꽉 찼을 때 배열의 크기를 증가시키는 코드를 추가한다.
- 6) push() 변경: 배열 크기를 늘리는 코드를 별도의 메서드(grow())로 분리한다. (리팩토링)
- 7) grow() 변경: 배열을 늘릴 때 새 배열 크기를 계산 하는 코드를 별도의 메서드(newCapacity())로 분리한다.(리팩토링)
- 8) pop() 추가
- 9) empty() 추가
- 10) Object의 clone() 메서드 재정의 : shallow copy 
- 11) Object의 clone() 메서드 변경 : deep copy
- 12) 제네릭 적용