# KT 에이블스쿨 5차 미니프로젝트  
## AI 이미지 생성 기반 도서 관리 시스템

---

## 프로젝트 개요  
본 프로젝트는 AI 이미지 생성 기술을 활용해 도서 표지를 자동 생성하는 기능을 포함한 도서 관리 시스템입니다.  
MSA(Event-Driven) 아키텍처를 적용하였으며, Kubernetes, Kafka, API Gateway, 서비스 메시, Docker, Azure CI/CD 파이프라인 등을 활용해 안정적이고 확장성 있는 시스템을 구축했습니다.

---

## 팀 구성 및 역할

| 이름    | 역할 및 담당 업무                         |
|---------|-----------------------------------------|
| 김민욱  | 타임키퍼, 협업 환경 구성자              |
| 남강민  | 검토 담당자, Kubernetes 클러스터 관리자 |
| 문승환  | 발표자, 모니터링 서버 담당자             |
| 진예나  | 서기, 파이프라인 관리자                  |
| 최재윤  | PPT 제작자, 컨테이너 레지스트리 관리자   |
| 허진수  | 조장, 서브 도메인 Owner                  |

---

## 기술 스택

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

## 주요 기능

- 사용자 로그인 및 인증 (로컬 스토리지 기반)  
- 마이페이지에서 개인 도서 목록 조회 및 관리  
- 도서 등록 및 수정 (제목, 내용, 카테고리, 표지 이미지)  
- AI 이미지 생성 (프롬프트 입력 → 이미지 자동 생성 및 적용)  
- 도서 목록 조회, 검색, 정렬, 페이징 처리  
- Event-Driven 아키텍처 기반 마이크로서비스 통신  

---

## Model
www.msaez.io/#/117431677/storming/f493bb3e3f53e3347de5cce4b7f8b54a


## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## 실행 방법

1. Kafka 서버 실행  
Kafka 서버가 먼저 실행되어야 합니다.
```bash
cd kafka
docker-compose up
Kafka 메시지 확인:

bash
복사
편집
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic <토픽명>
백엔드 마이크로서비스 실행
각 서비스 디렉토리에서 아래 명령어로 실행하세요. (Spring Boot 기반)

bash
복사
편집
cd author
mvn spring-boot:run

cd subscription
mvn spring-boot:run

cd writing
mvn spring-boot:run

cd point
mvn spring-boot:run

cd review
mvn spring-boot:run

cd ai
mvn spring-boot:run

cd book
mvn spring-boot:run
API Gateway 실행

bash
복사
편집
cd gateway
mvn spring-boot:run
프론트엔드 실행

bash
복사
편집
cd frontend
npm install
npm run start
UI 접속
웹 브라우저에서 아래 주소로 접속하여 서비스가 정상 작동하는지 확인하세요.
http://localhost:3000
