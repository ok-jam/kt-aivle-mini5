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
- **서비스 메시:** Istio (또는 유사 서비스)  
- **메시징 시스템:** Apache Kafka  
- **API 게이트웨이:** 적용  
- **CI/CD:** Azure DevOps 기반 자동화  
- **모니터링:** Prometheus, Grafana  

---

## ✨ 주요 기능

- 🔐 사용자 로그인 및 인증 (로컬 스토리지 기반)  
- 📚 마이페이지에서 개인 도서 목록 조회 및 관리  
- 📝 도서 등록 및 수정 (제목, 내용, 카테고리, 표지 이미지)  
- 🤖 AI 이미지 생성 (프롬프트 입력 → 이미지 자동 생성 및 적용)  
- 🔎 도서 목록 조회, 검색, 정렬, 페이징 처리  
- ⚙️ Event-Driven 아키텍처 기반 마이크로서비스 통신  

---

## 🔗 아키텍처 모델  
[🌐 MSAez 모델 바로가기](https://www.msaez.io/#/117431677/storming/f493bb3e3f53e3347de5cce4b7f8b54a)

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
