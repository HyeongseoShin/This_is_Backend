# 🧑‍💻 Spring Backend Study — 6 Weeks Intensive Curriculum

> **목표:**  
> 실무형 백엔드 개발자가 되기 위해 Spring Web → JPA → Security → JWT → Redis → S3 → Docker → AWS 배포까지  
> 실제 프로젝트에서 반드시 부딪히는 문제들을 문제 해결형 중심으로 학습한다.

---

<br/>

# 🎉 운영 방식

- 📅 **주 1회 스터디 + 발표**  
- 🔀 **GitHub PR 기반 코드 리뷰**  
- 🛠 **문제 해결형 미션 중심 학습**  
- 🚀 실무 문제를 직접 해결하며 성장하는 방식


<br/>
<br/>

# 📁 프로젝트 구조 / 업로드 규칙

이 스터디는 **1개의 GitHub 레포지토리**를 사용하며,  
각자 **독립된 폴더 + 주차별 개별 스프링 프로젝트** 구조를 따른다.

### 📌 규칙
- 각 `weekN` 폴더는 완전히 독립된 Spring Boot 프로젝트  
- 서로의 프로젝트에 영향을 주지 않음  
- 같은 주차라도 서로 완전히 다른 코드 작성 가능


<br/>
<br/>

# 📝 PR 규칙

1. 본인 이름 폴더 내에서 작업  
2. 주차가 끝나면 `main`으로 PR 생성  
3. 리뷰어는 상대방  
4. 리뷰 후 승인 → merge

<br/>

## ✔ PR 제목 컨벤션

[week1] 회원가입 예외 처리 미션 - hyeongseo

<br/>

## ✔ PR 내용 템플릿

📝 구현 내용
- 무엇을 구현했는지 상세 설명

✅ 체크리스트
 - 예외 처리 적용
 - Response Wrapper 적용
 - DTO Validation 적용

🤔 리뷰 요청 포인트
- 어떤 부분을 중점적으로 봐줬으면 하는지

<br/>
<br/>

## 📅 6주 전체 커리큘럼

### ⭐ 1주차 — Spring Web 기본기 + 계층 구조 + 예외 처리

**🎯 학습 목표**  
- Controller → Service → Repository 계층 구조 이해  
- DTO vs Entity 구분  
- 글로벌 예외 처리(`@ControllerAdvice`)  
- Validation 적용  

<br/>

**🧨 문제 해결형 미션**  
> “회원가입 API에서 발생 가능한 모든 예외를 잡아내고, 구조적 에러 응답을 설계하라”

✅ 다뤄야 할 케이스:  
- 이메일 중복  
- 잘못된 JSON Body  
- Validation 실패  
- 400 / 404 / 500 에러 구조 정의  

<br/>

**📌 주중 과제**  
- 회원 CRUD API 구현  
- 통일된 API Response Wrapper 제작  
- PR 제출 → 상호 코드 리뷰  

<br/>

---

<br/>

### ⭐ 2주차 — JPA 도메인 설계 + 연관관계 + QueryDSL

**🎯 학습 목표**  
- 연관관계 매핑(OneToMany, ManyToOne)  
- 연관관계의 주인 개념 이해  
- 지연 로딩과 N+1 문제 분석  
- QueryDSL 검색 기능 

<br/>

**🧨 문제 해결형 미션**  
> “게시글 리스트 조회 API에서 N+1 문제 제거하기”

✅ 필수 실험:  
- fetch join 적용  
- DTO Projection 변환  
- `@BatchSize` 비교  

<br/>

**📌 주중 과제**  
- Member–Post–Comment 도메인 설계  
- 게시글/댓글 CRUD API 구현  
- QueryDSL 검색 조건 추가  
- PR 리뷰 진행  

<br/>

---

<br/>

### ⭐ 3주차 — Spring Security + PasswordEncoder + JWT Access Token

**🎯 학습 목표**  
- FilterChain 동작 이해  
- PasswordEncoder 적용  
- Custom Authentication Filter 구현  
- Access Token 인증 기반 인가 처리  

<br/>

**🧨 문제 해결형 미션**  
> “게시글 작성 API를 인증 기반으로 보호하라”

✅ 해야 할 것:  
- 로그인 API 구현  
- Access Token 발급  
- Authorization Header 파싱  
- `@AuthenticationPrincipal`을 통한 인증 정보 전달  

<br/>

**📌 주중 과제**  
- JWT Access Token 기반 인증 구현  
- Custom Filter 등록  
- 인증 실패/인가 실패 핸들러 커스터마이징  
- PR 리뷰 진행  

<br/>

---
<br/>

### ⭐ 4주차 — Refresh Token + Redis + 토큰 재발급

**🎯 학습 목표**  
- Refresh Token 저장 전략 (쿠키/Redis)  
- Access Token 재발급 API 설계  
- 로그아웃 전략 (Refresh Token 제거)  
- Redis TTL / 자료구조 이해  

<br/>

**🧨 문제 해결형 미션**  
> “만료된 Access Token을 Refresh Token 기반으로 안전하게 재발급하라”

✅ 주의점:  
- Refresh Token Rotation 구현  
- Redis TTL 관리  
- 블랙리스트 전략 고민  

<br/>

**📌 주중 과제**  
- Refresh Token + Redis 저장 구조 구현  
- 토큰 재발급 API 구현  
- 로그아웃 기능 구현  
- PR 제출 + 리뷰  

<br/>

---

<br/>

### ⭐ 5주차 — 파일 업로드 + AWS S3 + Presigned URL

**🎯 학습 목표**  
- Presigned URL 원리 이해  
- 클라이언트 직접 업로드 방식 이해  
- Multipart vs URL 업로드 비교  
- S3 버킷 정책/권한 이해  

<br/>

**🧨 문제 해결형 미션**  
> “게시글 이미지 업로드 기능을 Presigned URL 기반으로 구현하라”

✅ 해야 할 작업:  
- 프론트에서 사용할 Presigned URL 발급 API 구현  
- 업로드된 이미지 URL DB 저장  
- 게시글 조회 시 이미지 반환  

<br/>

**📌 주중 과제**  
- Presigned URL API 구현  
- S3 연동 및 업로드 테스트  
- 이미지 포함 게시글 API 완성  
- PR 제출 + 리뷰  

<br/>

---

<br/>

### ⭐ 6주차 — Docker + Redis 캐싱 + 배포 + 성능 개선

**🎯 학습 목표**  
- Docker Compose(app + redis + mysql) 구성  
- 간단한 AWS EC2 배포  
- Redis Cache 적용  
- Cache Hit/Miss 분석  
- CloudWatch 기본 모니터링  

<br/>

**🧨 문제 해결형 미션**  
> “캐싱을 적용해 인기 게시글 API 속도를 10배 이상 개선하라”

✅ 필수 포함:  
- CacheManager / RedisTemplate 사용  
- TTL 전략 정의  
- Cache Evict 정책 설계  
- Docker Compose 기반 로컬 환경 구축  

<br/>

**📌 주중 과제**  
- 인기 게시글 API 캐싱 적용  
- Cache Hit/Miss 로그 출력  
- Docker Compose 전체 환경 구성  
- PR 제출 + 리뷰  
