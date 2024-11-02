# 🚀 Java-lotto-precourse

### 구현 제한사항

- depth는 2까지
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- else 예약어를 쓰지 않는다.
- Java Enum을 적용하여 프로그램을 구현한다.
- 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다

## ✅ 문제풀이 기능 요구사항

### 1. 로또의 기본 조건
- [x] 로또 번호의 숫자 범위는 1~45까지이다.
- [x] 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
  ~~~
  입력
  ------------------------
  Randoms.pickUniqueNumbersInRange(1, 45, 6);
  
  결과
  ------------------------ 
  중복되지않는 숫자 6개(1,2,3,4,5,6)
  ~~~

### 2. 사용자 로또 구매
- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
  - [x] 로또 1장의 가격은 1,000원이다.
  - [x] 필요한 로또 개수를 계산한다.
  - [x] 갯수에 따라 로또 발행한다.
  - [x] 발행한 로또를 반환한다.
  - [x] 발행한 로또를 출력한다
    - [ ] 로또 번호는 오름차순으로 정렬하여 보여준다.
    ~~~
    입력
    ------------------------
    구입금액을 입력해 주세요.
    8000
    
    결과
    ------------------------
    8개의 로또 티켓 생성
    [8, 21, 23, 41, 42, 43]
    [3, 5, 11, 16, 32, 38]
    [7, 11, 16, 35, 36, 44]
    [1, 8, 11, 31, 41, 42]
    [13, 14, 16, 38, 42, 45]
    [7, 11, 30, 40, 42, 43]
    [2, 13, 22, 32, 38, 45]
    [1, 3, 5, 14, 22, 45]
    ~~~

### 2. 당첨 번호 자동 생성
- [x] 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
  ~~~
  입력
  ------------------------
  Randoms.pickUniqueNumbersInRange(1, 45, 7);

  결과
  ------------------------
  중복되지않는 숫자 7개(1,2,3,4,5,6,7)
  ~~~
- [x] 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원


### 3. 로또 당청확인 - 당첨 번호 수동 입력
- [x] 당첨 번호와 보너스 번호를 입력받는다.
- [x] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
  - [x] 구매한 로또 번호와 당첨 번호를 비교해 당첨여부를 판단한다.
    - [x] 당첨과 보너스 숫자를 몇개 맞췄는가를 기준으로 랭킹을 판단한다.
    - [x] 구매한 로또 하나와 당첨 로또를 비교한다.
    - [x] 모든 구매한 로또와 당첨로또를 비교한다.
  - [x] 당첨 여부를 바탕으로 수익룰을 계산한다.
  - [ ] 수익률은 소수점 둘째 자리에서 반올림한다.
  ~~~
  입력 
  ------------------------
  당첨 번호를 입력해 주세요.
  1,2,3,4,5,6
  
  보너스 번호를 입력해 주세요.
  7
  
  결과
  ------------------------
  당첨 통계
  3개 일치 (5,000원) - 1개
  4개 일치 (50,000원) - 0개
  5개 일치 (1,500,000원) - 0개
  5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
  6개 일치 (2,000,000,000원) - 0개
  총 수익률은 62.5%입니다.
  ~~~

### 공통 요구사항
### 예외 처리
- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
- [x] 로또 구입 금액이 숫자 형식이 아닐때 예외처리
- [ ] 1,000원으로 나누어 떨어지지 않는 경우 예외 처리
