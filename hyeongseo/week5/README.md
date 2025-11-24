# 1주차 문제 해결형 미션 상세 명세

## 🧨 미션 주제
**회원가입 API에서 발생 가능한 모든 예외를 잡아내고, 구조적 에러 응답을 설계하라**

---

## ✅ 다뤄야 할 예외 케이스

| 예외 유형           | 상황                                   | 처리 방법                                 | HTTP 상태 코드           |
|--------------------|--------------------------------------|------------------------------------------|-------------------------|
| 이메일 중복         | 이미 존재하는 이메일로 가입 시도       | Custom Exception 생성 후 메시지 반환     | 400 Bad Request         |
| 잘못된 JSON Body    | 필수 필드 누락, 타입 오류 등           | `@Valid` + `@ExceptionHandler`          | 400 Bad Request         |
| Validation 실패     | 패스워드, 이름 등 DTO Validation 실패  | BindingResult 기반 오류 수집             | 400 Bad Request         |
| 기타 서버 오류       | DB 오류, NullPointer 등                | 글로벌 예외 처리(`@ControllerAdvice`)   | 500 Internal Server Error |
| 리소스 없음         | 조회/삭제 시 존재하지 않는 회원 요청   | Custom Exception                          | 404 Not Found           |

---

## 📌 주중 과제

### 1. 회원 CRUD API 구현
- 회원 등록(Create), 조회(Read), 수정(Update), 삭제(Delete) 기능
- 엔드포인트 예시:
  - POST   /api/members
  - GET    /api/members/{id}
  - PUT    /api/members/{id}
  - DELETE /api/members/{id}
  - GET    /api/members?email=xxx@example.com
- DTO와 Entity 구분 명확히 설계
- Validation 적용:
  - 이메일: 필수, 이메일 형식, 최대 50자
  - 패스워드: 필수, 최소 8자, 최대 20자
  - 이름: 필수, 최대 30자

### 2. 통일된 API Response Wrapper 제작
- 성공/실패 응답 모두 통일
- 성공 예시:
  - status: 200
  - success: true
  - message: "회원 등록 성공"
  - data: { id, email, name }
- 실패 예시:
  - status: 400
  - success: false
  - message: "이미 존재하는 이메일입니다."
  - errors: [{ field, rejectedValue, reason }]

### 3. PR 제출 및 상호 코드 리뷰
- GitHub PR 기반 코드 리뷰 진행
- 리뷰 포인트:
  - 예외 처리 구조의 명확성
  - Response Wrapper 일관성
  - Validation 적용 여부
  - 코드 가독성 및 설계

---

## 🔧 추가 가이드
1. `@ControllerAdvice` + `@ExceptionHandler` 활용하여 글로벌 예외 처리  
2. Validation 실패 시 `BindingResult` 사용하여 필드별 에러 반환  
3. Custom Exception 클래스로 의미 있는 에러 메시지 관리  
4. 모든 API 응답은 반드시 Response Wrapper를 통해 반환
