# 구인구직웹 프로젝트

DEVELOPMENT MOTIVATION
---
> 구인구직싸이트 -
> > 구인구직을 하는 입장에서 사람인이나 잡코리아와 같은 사이트 <br> 
> > 보다 더 간편하게 정보를 수집할 수 있는 사이트 <br> 
 

HISTORY
---
[TOTAL](DOCUMENT/HISTORY/TOTAL) | [나재현](DOCUMENT/HISTORY/나재현) | [이동환](DOCUMENT/HISTORY/이동환) | [박정현](DOCUMENT/HISTORY/박정현) | [최원준](DOCUMENT/HISTORY/최원준) |


PLANS
---
 |LANGUAGE|PLAN|IMPLEMENT|DESCRIPTION|
 |-|-|-|-|
 |JAVA|2024/04/08 ~ 2024/04/23|-|-|
 |JSP/SERVLET|2024/04/24 ~ 2024/04/28|-|-|
 |SPRING STS3|2024/04/28 ~ 2024/05/14|-|-|
 |SPRING BOOT|2024/05/15 ~ 2024/06/30|-|-|
 
 

MEMBERERS
--- 
|NAME|ROLE|DETAILS|DESCRIPTION| 
|---|---|---|---|
|정우균|FN| FrontController / Docment 관리 / Dependencies  관리 |---|
|최원준|FN| 모든PAGE와 서버간 REQ / RESP |---|
|나재현|BN| 유저공통 - ID찾기 / PW찾기 / 회원가입 유효성검사 |---|
|이동환|BN| SEEKER 이력서 CRUD / 공지사항 CRUD |---|
|박정현|BN| OFFER 기업정보 CRUD / 기업공고 CRUD |---|

SKILLS
---

#### FN
---
<img src="https://img.shields.io/badge/HTML5-3366CC?style=for-the-badge&logo=htmlacademy&logoColor=white"> <img src="https://img.shields.io/badge/CSS-1572B6?style=for-the-badge&logo=css3&logoColor=white"> <img src="https://img.shields.io/badge/JAVASCRIPT-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white"> <img src="https://img.shields.io/badge/JQUERY-0769AD?style=for-the-badge&logo=jquery&logoColor=white"> 


#### BN
---
<img src="https://img.shields.io/badge/JAVA-005571?style=for-the-badge&logo=doubanread&logoColor=white"> <img src="https://img.shields.io/badge/JSP-1E8CBE?style=for-the-badge&logo=doubanread&logoColor=white"> <img src="https://img.shields.io/badge/SERVLET-4B4B77?style=for-the-badge&logo=doubanread&logoColor=white"> <img src="https://img.shields.io/badge/SPRING-STS3-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> <img src="https://img.shields.io/badge/SPRINGBOOT-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> 

#### DATABASE
---
<img src="https://img.shields.io/badge/MYSQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white">  


#### DEVOPS
---
<img src="https://img.shields.io/badge/GIT-F05032?style=for-the-badge&logo=git&logoColor=white"> <img src="https://img.shields.io/badge/GITHUB-181717?style=for-the-badge&logo=github2&logoColor=white"> <img src="https://img.shields.io/badge/AWS-EC2-FF9900?style=for-the-badge&logo=amazonec2&logoColor=white"> <img src="https://img.shields.io/badge/DOCKER-2496ED?style=for-the-badge&logo=docker&logoColor=white"> <img src="https://img.shields.io/badge/DOCKERHUB-2496ED?style=for-the-badge&logo=docker&logoColor=white"> <img src="https://img.shields.io/badge/JENKINS-D24939?style=for-the-badge&logo=jenkins&logoColor=white"> 


END POINT DOC
---
|URI|REQUEST METHOD|REQUEST PARAMETER TYPE|RESPONSE VALUE TYPE|DESCRIPTION|
|---|---|---|---|---|
|/user/confirmid|GET/POST|NICKNAME POHNE TYPE|String|---|
|/user/confirmpw|GET/POST|NICKNAME USERNAME PHONE|String|---|
|---|---|---|---|---|
|/seeker/resume/add|GET/POST|form|String|---|
|/seeker/resume/update|GET/POST|ID|String|---|
|/seeker/resume/read|GET|ID|String|---|
|/seeker/resume/list|GET|---|String|---|
|/seeker/delete|GET/POST|ID|String|---|
|---|---|---|---|---|
|/offer/join|GET|---|void|---|
|---|---|---|---|---|
|/offer/company/add|GET/POST|McodelAttribute<br>CompanyDto|void String|---|
|/offer/company/read|GET|Model|void String|---|
|/offer/company/delete|GET/POST|ID|String|---|
|/offer/company/update|GET/POST|ModelAttribute<br>Company|void|---|
|---|---|---|---|---|
|/offer/jobopening/read|GET|---|void|---|
|/offer/jobopening/add|GET/POST|---|void|---|

DEPENDENCIES LIST
---
|CAT|NAME|DESCRIPTION|LINK|-|-|
|-|-|-|-|-|-|
|FN|WEB| BOOT WEB|org.springframework.boot:spring-boot-starter-web|-|-|
|FN|THYMELEAF| THYMELEAF|org.springframework.boot:spring-boot-starter-thymeleaf|-|-|
|BN|LOMBOK|LOMBOK| org.projectlombok:lombok|-|-|
|BN|SPRING_SECURITY| SPRING_SECURITY|org.springframework.boot:spring-boot-starter-security|-|-|
|BN|SECURITY+THYMELEAF| SECURITY+THYMELEAF|org.thymeleaf.extras:thymeleaf-extras-springsecurity6|-|-|
|BN|ORM_JPA| ORM_JPA|org.springframework.boot:spring-boot-starter-data-jpa|-|-|
|BN|MAIL| MAIL|org.springframework.boot:spring-boot-starter-mail|-|-|
|BN|DEVTOOLS| DEVTOOLS|org.springframework.boot:spring-boot-devtools|-|-|
|BN|VALIDATOR| VALIDATOR|org.springframework.boot:spring-boot-starter-validation|-|-|
|BN|OAUTH2-Client| OAUTH2-Client|org.springframework.boot:spring-boot-starter-oauth2-client|-|-|
|BN|TX| TX|org.springframework:spring-tx|-|-|
|DB|DBCONN BASIC| DBCONN BASIC|org.springframework.boot:spring-boot-starter-jdbc|-|-|
|DEVOPS|-|-|-|-|-|


ERD[KoreaJobDb]
---
![20240425155554](https://github.com/jungwoogyun/EM-01-PROJECTS/assets/84259104/8631169d-3c85-4be4-a097-613bf1e5b7e0)


FILE TREES[JSP/SERVLET]
--- 
C:.
├─.gradle
│  ├─8.7
│  │  ├─checksums
│  │  ├─dependencies-accessors
│  │  ├─executionHistory
│  │  ├─expanded
│  │  ├─fileChanges
│  │  ├─fileHashes
│  │  └─vcsMetadata
│  ├─buildOutputCleanup
│  └─vcs-1
├─.idea
├─gradle
│  └─wrapper
├─out
│  └─production
│      ├─classes
│      │  └─com
│      │      └─example
│      │          ├─app
│      │          │  └─controller
│      │          └─jobKoreaIt
│      │              ├─config
│      │              │  └─auth
│      │              │      ├─exceptionHandler
│      │              │      ├─jwt
│      │              │      ├─loginHandler
│      │              │      ├─logoutHandler
│      │              │      └─provider
│      │              ├─controller
│      │              │  └─user
│      │              │      ├─offer
│      │              │      └─seeker
│      │              ├─domain
│      │              │  ├─common
│      │              │  │  ├─dto
│      │              │  │  ├─entity
│      │              │  │  ├─repository
│      │              │  │  └─service
│      │              │  ├─offer
│      │              │  │  ├─dto
│      │              │  │  ├─entity
│      │              │  │  ├─repository
│      │              │  │  └─service
│      │              │  └─seeker
│      │              │      ├─dto
│      │              │      ├─entity
│      │              │      ├─repository
│      │              │      └─service
│      │              └─properties
│      └─resources
│          ├─static
│          │  ├─assets
│          │  ├─css
│          │  │  ├─community
│          │  │  ├─mobile
│          │  │  └─user
│          │  └─js
│          │      ├─community
│          │      └─user
│          └─templates
│              ├─community
│              ├─fragments
│              ├─offer
│              │  └─company
│              ├─seeker
│              │  └─resume
│              └─user
└─src
    ├─main
    │  ├─generated
    │  ├─java
    │  │  └─com
    │  │      └─example
    │  │          └─jobKoreaIt
    │  │              ├─config
    │  │              │  └─auth
    │  │              │      ├─exceptionHandler
    │  │              │      ├─jwt
    │  │              │      ├─loginHandler
    │  │              │      ├─logoutHandler
    │  │              │      └─provider
    │  │              ├─controller
    │  │              │  └─user
    │  │              │      ├─offer
    │  │              │      └─seeker
    │  │              ├─domain
    │  │              │  ├─common
    │  │              │  │  ├─dto
    │  │              │  │  ├─entity
    │  │              │  │  ├─repository
    │  │              │  │  └─service
    │  │              │  ├─offer
    │  │              │  │  ├─dto
    │  │              │  │  ├─entity
    │  │              │  │  ├─repository
    │  │              │  │  └─service
    │  │              │  └─seeker
    │  │              │      ├─dto
    │  │              │      ├─entity
    │  │              │      ├─repository
    │  │              │      └─service
    │  │              └─properties
    │  └─resources
    │      ├─static
    │      │  ├─assets
    │      │  ├─css
    │      │  │  ├─community
    │      │  │  ├─mobile
    │      │  │  └─user
    │      │  └─js
    │      │      ├─community
    │      │      └─user
    │      └─templates
    │          ├─community
    │          ├─fragments
    │          ├─offer
    │          │  └─company
    │          ├─seeker
    │          │  └─resume
    │          └─user
    └─test
        └─java
            └─com
                └─example
                    └─jobKoreaIt
                        └─domain
                            └─seeker
                                └─repository
                            join.jsp
                            login.jsp
```
---

