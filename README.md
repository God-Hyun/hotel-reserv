# **호텔 예약 시스템 프로젝트**

### **프로젝트 개요**
호텔 예약 시스템 프로젝트는 사용자와 관리자의 역할에 따라 기능을 구분하고, Spring Boot와 Spring Security를 통해 보안을 적용한 웹 애플리케이션입니다.
본 프로젝트를 수행할 때 실제 서비스를 가정하여 인증과 권한 관리, 비동기 데이터 통신을 구현하는 데 중점을 두었습니다.

---

### **프로젝트 목표**
이 프로젝트를 통해 다음과 같은 기술 역량을 높이고자 했습니다:
- **Spring Security를 통한 보안 구현**: 사용자 인증 및 권한 부여 로직을 구성하고, 권한에 따라 페이지 접근을 제어
- **REST API와 AJAX를 통한 비동기 데이터 통신**: 서버와 클라이언트 간 데이터 전송을 최적화하여 웹사이트의 응답성을 개선
- **CRUD 구현 역량 향상**: 예약, 회원 관리, 게시판 등 도메인 기능별 CRUD 구현

---

### **핵심 기능**
1. **회원 관리**
   - 회원가입 및 로그인/로그아웃 기능 제공
   - Spring Security의 Form Login을 활용하여 사용자 인증 및 권한 관리

2. **예약 기능**
   - **일반 사용자**: 자신의 예약 내역만 조회 가능
   - **관리자**: 모든 예약 내역 조회 및 관리 가능
   - 로그인한 사용자만 예약 가능하며, 예약 후 조회 및 관리 기능 제공

3. **게시판 기능**
   - 공지사항과 후기 관리로 분리하여 CRUD 기능 제공
   - 일반 사용자 및 관리자 모두 글 작성, 수정, 삭제 가능
   - 관리자만 공지사항 작성 가능
     
4. **주변 관광지 정보**
   - 주변 관광지에 대한 정보를 확인할 수 있습니다.

---

### **기술 스택**
- **백엔드**: Java, Spring Boot, Spring Data JPA, Spring Security
- **프론트엔드**: JavaScript, HTML/CSS (템플릿엔진 : Thymeleaf)
- **데이터베이스**: MySQL
- **서버/운영체제**: Apache, Tomcat, Ubuntu 22.04 LTS
- **협업 및 관리 도구**: Git, IntelliJ IDEA
- **추가 라이브러리 및 도구**: Naver Maps API, Bootstrap3

---

### **프로젝트 구조**
MVC 아키텍처에 따라 다음과 같이 계층을 구분하여 유지보수성과 확장성을 높였습니다:
- **Controller**: RESTful API 설계 및 클라이언트 요청 처리
- **Service Layer**: 비즈니스 로직을 처리하며, Controller와 Repository 간의 데이터를 중계하여 코드 재사용성과 유지보수성을 강화
- **Repository**: JPA를 사용하여 데이터 접근 로직을 구현하며, 도메인 기능별 CRUD 메서드를 제공
- **View**: Thymeleaf를 사용해 서버에서 HTML을 렌더링하여 사용자에게 정보 제공
- **DTO (Data Transfer Object)**: 계층 간 데이터 전달을 위한 객체로, 도메인 엔터티의 특정 필드만을 포함하여 필요한 데이터만 전송합니다. 이를 통해 도메인 엔터티의 불필요한 데이터 노출을 방지하고, API 응답의 효율성을 향상

---

### **주요 기술 및 학습 포인트**
- **Spring Security**: 사용자 인증과 권한 관리를 위해 Spring Security의 Form Login, 권한별 페이지 접근 설정 등을 구현하여 보안성을 강화했습니다.
- **AJAX & REST API**: 비동기 데이터 통신을 통해 사용자 경험을 향상시키고, 서버와 클라이언트 간의 데이터 전송 효율을 높였습니다.
- **데이터베이스 설계 및 테이블 관리**: 불필요한 JOIN 연산을 최소화하는 데이터베이스 구조 설계, 중복 데이터 관리 및 조회 효율성을 고려한 Booking 테이블 구성

---

### **회고 및 개선점**
본 프로젝트를 통해 **보안 관리와 REST API 설계, CRUD 구현** 등의 기술을 실제 서비스 수준에서 학습하고 적용하는 기회를 가졌습니다.
향후에는 JWT 기반 인증 방식을 도입하여 보안성을 한층 강화하고, 클라우드 환경에서의 배포와 운영까지 경험해 보고 싶습니다.

