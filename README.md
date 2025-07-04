# 🚀 KT 에이블스쿨 5차 미니프로젝트  
## 🎨 AI 이미지 생성 기반 도서 관리 시스템

---

## 📌 프로젝트 개요  
본 프로젝트는 **AI 이미지 생성 기술**을 활용해 도서 표지를 자동 생성하는 도서 관리 시스템입니다.  
**MSA(Event-Driven)** 아키텍처를 기반으로 Kubernetes, Kafka, API Gateway, 서비스 메시, Docker, Azure CI/CD 파이프라인 등을 활용하여 **확장성과 안정성**을 확보하였습니다.

---

## 👥 팀원 소개

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/ok-jam">
        <img src="https://github.com/ok-jam.png" width="100px;" alt="김민욱"/>
        <br /><b>김민욱</b>
      </a>
      <br />⏰ 타임키퍼<br />협업 환경 구성자
    </td>
    <td align="center">
      <a href="https://github.com/namgangmin">
        <img src="https://github.com/namgangmin.png" width="100px;" alt="남강민"/>
        <br /><b>남강민</b>
      </a>
      <br />🔍 검토 담당자<br />Kubernetes 클러스터 관리자
    </td>
    <td align="center">
      <a href="https://github.com/munseunghwan">
        <img src="https://github.com/munseunghwan.png" width="100px;" alt="문승환"/>
        <br /><b>문승환</b>
      </a>
      <br />📢 발표자<br />모니터링 서버 담당자
    </td>
    <td align="center">
      <a href="https://github.com/jinyena">
        <img src="https://github.com/jinyena.png" width="100px;" alt="진예나"/>
        <br /><b>진예나</b>
      </a>
      <br />📝 서기<br />파이프라인 관리자
    </td>
    <td align="center">
      <a href="https://github.com/jaeeyun103">
        <img src="https://github.com/jaeeyun103.png" width="100px;" alt="최재윤"/>
        <br /><b>최재윤</b>
      </a>
      <br />🎨 PPT 제작자<br />컨테이너 레지스트리 관리자
    </td>
    <td align="center">
      <a href="https://github.com/201924611">
        <img src="https://github.com/201924611.png" width="100px;" alt="허진수"/>
        <br /><b>허진수</b>
      </a>
      <br />🧑‍✈️ 조장<br />서브 도메인 Owner
    </td>
  </tr>
</table>

---

## 🛠 기술 스택

- **Frontend:** Vite + React + Material UI  
- **Backend:** Java 11, Spring Boot 2.3.x, Spring Cloud Hoxton.SR12  
- **Database:** H2 (개발), 운영 시 MySQL/PostgreSQL 가능  
- **Architecture:** MSA + Event-Driven  
- **Containerization:** Docker  
- **Orchestration:** Kubernetes  
- **Service Mesh:** Istio  
- **Message Queue:** Apache Kafka  
- **CI/CD:** Azure DevOps  
- **Monitoring:** Grafana, Loki

---

## ✨ 주요 기능

### 🧾 전체 요약

- 🔐 사용자 로그인 및 인증  
- 🧑‍💼 작가 등록 및 승인  
- 📚 책 등록, 열람, 베스트셀러 자동 등록  
- 🤖 AI 이미지 생성 및 반영  
- 💬 리뷰 작성 및 조회  
- 💰 포인트 충전/차감 및 통신사 혜택  
- 📝 집필 임시 저장 및 책 등록 요청  
- ⚙️ Event-Driven 기반 마이크로서비스 통신  

---

### 📘 서비스별 기능

#### 📘 Book Service
- 📄 책 목록 조회  
- 📌 책 상세 조회  
- ✍️ 책 등록 (`Writing` 서비스 연동)  
- 👀 책 열람 요청 → 조회수 증가  
- 🏆 베스트셀러 자동 등록  

#### 🧑‍🎨 Author Service
- 🧾 작가 등록 (승인 대기 상태)  
- 📋 작가 목록 조회  
- ✅ 작가 승인/반려  
- ❌ 작가 삭제  

#### 🧠 AI Service
- 🎨 AI 이미지 생성 (책 제목/내용 기반)  
- 🔍 이미지 결과 조회 및 적용  

#### 💰 Point Service
- ➕ 포인트 충전  
- ➖ 포인트 차감 (열람/구독 시)  
- 🎁 회원가입 시 기본 + KT 추가 포인트 지급  

#### ✏️ Review Service
- 💬 리뷰 목록 조회  
- 📝 리뷰 작성  

#### 🛠 Writing Service
- 🔁 책 정보 → AI 서비스 전달  
- 📤 책 등록 요청 (`Book` 서비스에 전달)  
- 💾 책 내용 임시 저장  

---

## 🗺 아키텍처 모델  
[🔗 MSAez 모델 보기](https://www.msaez.io/#/117431677/storming/f493bb3e3f53e3347de5cce4b7f8b54a)

---

## ⚙️ 개발 환경 및 필수 버전

> 아래 환경에 맞춰 개발되었으며, 원활한 실행을 위해 해당 버전을 권장합니다.

### 🖥 Backend
- Java 11  
- Spring Boot 2.3.x  
- Spring Cloud Hoxton.SR12  
- Maven 3.x 이상

---

## ▶️ 실행 방법

### 1️⃣ Kafka 서버 실행
```bash
cd kafka
docker-compose up

cd ../infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic <토픽명>
```

### 2. 백엔드 마이크로서비스 실행
```bash
cd ../../author
mvn spring-boot:run
cd ../subscription
mvn spring-boot:run
cd ../writing
mvn spring-boot:run
cd ../point
mvn spring-boot:run
cd ../review
mvn spring-boot:run
cd ../ai
mvn spring-boot:run
cd ../book
mvn spring-boot:run
```

# 3. API Gateway 실행
```bash
cd ../gateway
mvn spring-boot:run
```
# 4. 프론트엔드 실행
```bash
cd ../frontend
npm install
npm run start
```
