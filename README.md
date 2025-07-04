# 🚀 KT 에이블스쿨 5차 미니프로젝트  
## 🎨 AI 이미지 생성 기반 도서 관리 시스템

---

## 📌 프로젝트 개요  
본 프로젝트는 AI 이미지 생성 기술을 활용해 도서 표지를 자동 생성하는 기능을 포함한 도서 관리 시스템입니다.  
MSA(Event-Driven) 아키텍처를 적용하였으며, Kubernetes, Kafka, API Gateway, 서비스 메시, Docker, Azure CI/CD 파이프라인 등을 활용해 안정적이고 확장성 있는 시스템을 구축했습니다.

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

## 🛠 기술 스택

- **프론트엔드:** Vite + React  
- **백엔드:** Spring Boot (Java)  
- **아키텍처:** MSA + Event-Driven  
- **컨테이너 관리:** Docker, Kubernetes  
- **서비스 메시:** Istio
- **메시징 시스템:** Apache Kafka  
- **API 게이트웨이:** 적용  
- **CI/CD:** Azure DevOps 기반 자동화  
- **모니터링:** loki, Grafana  

---

## ✨ 주요 기능

### 🧾 전체 요약

- 🔐 사용자 로그인 및 인증 (로컬 스토리지 기반)
- 🧑‍💼 작가 등록 및 승인 요청 처리
- 📚 책 등록, 열람, 베스트셀러 등록
- 🧠 AI 이미지 자동 생성 및 결과 반영
- 💬 리뷰 작성 및 조회
- 💰 포인트 충전/차감 및 KT 가입자 혜택
- 📝 작가 집필 관리 (임시 저장, 등록 요청)
- ⚙️ Event-Driven 마이크로서비스 통신 구조

---

### 📘 1. 책 서비스 (Book Service)

- 📄 **책 목록 조회**: 시스템에 등록된 모든 책 목록을 불러옵니다.  
- 📌 **책 상세 조회**: 선택한 책의 상세 정보를 확인할 수 있습니다.  
- ✍️ **책 등록**: 작가가 집필한 책을 시스템에 등록합니다. (writing 서비스 연동)  
- 👀 **책 열람 요청**: 책 열람 시 조회수가 증가하며, 조건 충족 시 베스트셀러로 등록됩니다.  
- 🏆 **베스트셀러 등록**: 조회수가 기준을 초과하면 자동 등록됩니다.

---

### 🧑‍🎨 2. 작가 서비스 (Author Service)

- 🧾 **작가 등록**: 새로운 작가 등록 시 상태는 '승인 대기(PENDING)'로 설정됩니다.  
- 📋 **작가 목록 조회**: 전체 작가 리스트를 불러옵니다.  
- ✅ **승인/반려 처리**: 관리자가 작가 신청을 승인하거나 반려합니다.  
- ❌ **작가 삭제**: 필요 시 작가 정보를 시스템에서 제거합니다.

---

### 🧠 3. AI 서비스 (AI Service)

- 🎨 **AI 이미지 생성**: 제목, 요약 등 책 정보를 기반으로 표지 이미지를 자동 생성합니다.  
- 🔍 **AI 결과 조회**: 생성된 이미지 결과를 확인하고 반영할 수 있습니다.

---

### 💰 4. 포인트 서비스 (Point Service)

- ➕ **포인트 충전**: 사용자가 직접 포인트를 충전할 수 있습니다.  
- ➖ **포인트 차감**: 책 열람 또는 구독 시 자동 차감 (부족 시 실패)  
- 🎁 **가입 혜택**: 신규 회원가입 시 기본 포인트 + KT 사용자 추가 지급

---

### ✏️ 5. 리뷰 서비스 (Review Service)

- 💬 **리뷰 조회**: 특정 책에 대한 사용자 리뷰 목록을 확인합니다.  
- 📝 **리뷰 작성**: 책에 대한 의견이나 평점을 남길 수 있습니다.

---

### 🛠 6. 집필 서비스 (Writing Service)

- 🔁 **책 정보 전달**: 작가가 작성 중인 책 정보를 AI 서비스에 전달하여 이미지 생성을 요청합니다.  
- 📤 **책 등록 요청**: 작성이 완료된 책을 `book` 서비스에 등록합니다.  
- 💾 **임시 저장**: 작가가 작성 중인 내용을 임시 저장할 수 있어 중단/복귀가 용이합니다.

---

## 🔗 아키텍처 모델  
[🌐 MSAez 모델 바로가기](https://www.msaez.io/#/117431677/storming/f493bb3e3f53e3347de5cce4b7f8b54a)

---

## ⚙️ 개발 환경 및 필수 버전

아래 환경에 맞춰 개발 및 실행이 이루어졌으며, 원활한 실행을 위해 해당 버전을 권장합니다.

### 🖥 Backend
- Java 11
- Spring Boot 2.3.x
- Spring Cloud Hoxton.SR12
- Maven 3.x 이상
  
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
