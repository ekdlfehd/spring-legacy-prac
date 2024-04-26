# 스프링 -프로젝트- 의류 쇼핑몰

## 🖥️ 프로젝트 소개
여러가지 참고해서 의류쇼핑몰을 만들어 보았습니다.
<br>

### 🧑‍🤝‍🧑 맴버구성

- 안정민(Solo Project)

### ⚙️ 개발 환경
- `Java 11.0.18`
- `JDK 11.0.18+9-LTS-195`
- **IDE** : Spring Tool Suite3 - 3.9.18.RELEASE
- **Framework** : Spring
- **Database** : Oracle DB(11xe)
- **ORM** : Mybatis
  
## 📌 주요 기능


### ✔️ 로그인 - <a href="https://github.com/ekdlfehd/spring-legacy-prac/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(%EB%A1%9C%EA%B7%B8%EC%9D%B8,%EB%A1%9C%EA%B7%B8%EC%95%84%EC%9B%83,%EB%A9%94%EC%9D%B8%EB%B7%B0%EC%9D%B4%EB%AF%B8%EC%A7%80)" >상세보기 - WIKI 이동</a>
- DB 요청하여 아이디, 비번 일치 여부 확인
- Ajax를 사용하여 오류시 Text 뿌리기
- 로그인 시 세션(Session) 생성
  
### ✔️ 회원가입 - <a href="https://github.com/ekdlfehd/spring-legacy-prac/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85) " >상세보기 - WIKI 이동</a>
- 주소 API 연동
- ID 중복 체크
  
### ✔️ 상품 조회 / 상품정보 - <a href="https://github.com/ekdlfehd/spring-legacy-prac/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(%EC%83%81%ED%92%88%EC%A1%B0%ED%9A%8C,%EC%83%81%ED%92%88%EC%A0%95%EB%B3%B4)" >상세보기 - WIKI 이동</a>
- 메인 페이지에 상품 검색
- 키워드에 맞는 제품 나열
- 검색 후 사용자가 클릭한 의류 상세정보 확인가능
- 리뷰 기능(수정,삭제)
- 원하는 수량만큼 장바구니에 담기

### ✔️ 관리자 페이지1(상품 목록)- <a href="https://github.com/ekdlfehd/spring-legacy-prac/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(-%EA%B4%80%EB%A6%AC%EC%9E%90-%ED%8E%98%EC%9D%B4%EC%A7%801-%22-%EC%83%81%ED%92%88%EB%AA%A9%EB%A1%9D-%22-)" >상세보기 - WIKI 이동</a>
- 기업회원으로 가입해야 보이는 관리자페이지
- 상품목록 나열 
- 상품 상세 정보
- 페이징처리
- 상품조회,읽기,수정,삭제(CRUD게시판)

### ✔️ 관리자 페이지2(상품 등록) - <a href="https://github.com/ekdlfehd/spring-legacy-prac/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(-%EA%B4%80%EB%A6%AC%EC%9E%90-%ED%8E%98%EC%9D%B4%EC%A7%802-%22-%EC%83%81%ED%92%88%EB%93%B1%EB%A1%9D-%22-)" >상세보기 - WIKI 이동</a>
- 상품이미지 등록 및 상품이미지 띄우기
- 의류 카테고리

### ✔️ 관리자 페이지3(주문 현황) - <a href="https://github.com/ekdlfehd/spring-legacy-prac/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(-%EA%B4%80%EB%A6%AC%EC%9E%90-%ED%8E%98%EC%9D%B4%EC%A7%803-%22-%EC%A3%BC%EB%AC%B8-%ED%98%84%ED%99%A9-%22-)" >상세보기 - WIKI 이동</a> 
- 결제된 내역의 현황

### ✔️ 장바구니 - <a href="https://github.com/ekdlfehd/spring-legacy-prac/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(%EC%9E%A5%EB%B0%94%EA%B5%AC%EB%8B%88)" >상세보기 - WIKI 이동</a> 
- 장바구니 리스트
- 장바구니 삭제
- 체크리스트로 원하는 품목 결제
- 배송비와 적립포인트 , 결제금액을 확인할 수 있음

### ✔️ 결제 시스템 - <a href="https://github.com/ekdlfehd/spring-legacy-prac/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(%EA%B2%B0%EC%A0%9C%EC%8B%9C%EC%8A%A4%ED%85%9C)" >상세보기 - WIKI 이동</a> 
- 결제기능
- 배송지 직접입력가능
- 결제 후 장바구니 제거
- 사용자의 금액 , 포인트 결산
