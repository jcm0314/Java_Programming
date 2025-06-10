# 단어 카운팅 프로그램

이 프로젝트는 단어의 출현 빈도를 카운트하고 관리하는 Java 프로그램입니다.

## 클래스 구조

### 1. Word 클래스
- 기본 단어 클래스
- 단어 문자열을 저장하고 관리
- `getWord()`: 단어 반환
- `toString()`: 단어 문자열 반환

### 2. Countable 인터페이스
- 카운트 기능을 정의하는 인터페이스
- `increaseCount()`: 카운트 증가
- `decreaseCount()`: 카운트 감소

### 3. CountableWord 클래스
- `Word` 클래스를 상속하고 `Countable` 인터페이스 구현
- 단어의 출현 빈도를 카운트
- `getCount()`: 현재 카운트 반환
- `toString()`: "단어(카운트)" 형식으로 출력

### 4. CountableWordsList 클래스
- `Iterable<CountableWord>` 인터페이스 구현
- 단어들을 리스트로 관리
- `addWord()`: 단어 추가 또는 카운트 증가
- `removeWord()`: 단어 제거 또는 카운트 감소
- `iterator()`: 단어 리스트 순회를 위한 이터레이터 반환

### 5. CountableWordsListIterator 클래스
- `Iterator<CountableWord>` 인터페이스 구현
- `CountableWordsList`의 요소들을 순회
- `hasNext()`: 다음 요소 존재 여부 확인
- `next()`: 다음 요소 반환
- `remove()`: 현재 요소 제거

### 6. CountableWordsMap 클래스
- 단어들을 첫 글자별로 그룹화하여 관리
- `process()`: 단어 리스트 처리
- `print()`: 그룹화된 단어들 출력

### 7. App 클래스
- 메인 프로그램
- 예제 실행 및 테스트
- 단어 리스트 생성 및 정렬
- `CountableWordsList`와 `CountableWordsMap` 사용 예시

## 실행 결과 예시
```
apple(1)
carrot(3)
banana(2)
avocado(1)

a: apple(1) avocado(1)
b: banana(2)
c: carrot(3)
```

## 주요 기능
1. 단어 추가 및 카운트
2. 단어 제거 및 카운트 감소
3. 알파벳 순 정렬
4. 첫 글자별 그룹화
5. 단어 빈도수 출력
