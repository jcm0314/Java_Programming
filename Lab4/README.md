# LAB4, 자바프로그래밍 2분반, 32203919 장천명명

## 개요
이 프로젝트는 화산과 지진 등 자연재해 데이터를 효과적으로 관리, 검색, 정렬하는 자바 프로그램입니다. 
다양한 파싱, Finder, Comparator, Sorter 기능을 통해 데이터를 객체로 변환하고, 조건에 따라 검색 및 정렬할 수 있습니다.

---

## 폴더 구조 및 주요 클래스

- **LAB4.java** : 메인 클래스. 데이터 파싱, 검색, 정렬 등 전체 기능을 테스트합니다.
- **model/** : 자연재해, 화산, 지진 등 데이터 모델 클래스 정의
    - `NaturalHazard.java` : 자연재해의 공통 속성(연,월,일,위치,좌표)
    - `Volcano.java` : 화산 정보(이름, 국가, 고도, 유형, VEI)
    - `Earthquake.java` : 지진 정보(깊이, 규모)
    - `VolcanicExplosivityIndex.java` : 화산 폭발 지수(VEI) 열거형
- **parser/** : 문자열 배열 데이터를 객체 배열로 변환하는 파서
    - `VolcanoParser.java`, `EarthquakeParser.java`
- **finder/** : 다양한 조건으로 데이터를 검색하는 Finder 클래스 및 인터페이스
    - 예: `VolcanoCountryFinder`, `EarthquakeMagnitudeFinder` 등
- **comparator/** : 정렬 기준을 제공하는 Comparator 클래스
    - 연도, 월, 이름, 국가, VEI, 규모 등 다양한 기준 지원
- **sort/** : 정렬 기능을 제공하는 Sorter 클래스
    - `VolcanoSorter.java`, `EarthquakeSorter.java`
- **util/** : 출력 등 유틸리티 기능
    - `PrintUtil.java`

---

## 주요 기능

- **데이터 파싱** : 문자열 배열 데이터를 객체 배열로 변환
- **Finder** : 국가, 고도, 유형, VEI, 깊이, 규모 등 다양한 조건으로 검색
- **Sorter** : 연도, 월, 이름, 국가, VEI, 규모 등 다양한 기준으로 정렬
- **출력** : 보기 좋은 형식으로 결과 출력


---

## 예시

- 이탈리아의 화산만 검색
- 고도 3000~6000m 화산 검색
- VEI 4 이상의 화산 검색
- 진도 8.0~9.0 지진 검색
- 연도/VEI/진도 등 다양한 기준으로 정렬

---

- 각 Finder, Comparator, Sorter 클래스는 확장 및 커스터마이즈가 용이하도록 설계되어 있습니다.
- 데이터는 2차원 문자열 배열로 입력받아 파싱 후 객체로 관리합니다.

---
