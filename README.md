# spring-jdbc
스프링 jdbc를 사용해서 만드는 독서 감상 프로그램

## 실행방법
1. Mysql 데이터베이스를 준비합니다.
2. `docker compose up` bash 명령어로 mysql을 실행시킵니다.
3. `docker ps` 명령어로 컨테이너가 정상적으로 실행되었는지 확인합니다(`Up` 인지 확인).
4. resources 하단에 `init.sql` 파일을 mysql cli 또는 인텔리제이 내 Query Console에서 데이터베이스와 테이블을 생성합니다.
5. docker ps 명령어로 컨테이너가 정상적으로 실행되었는지 확인합니다.
6. resources 하단 `bookApiTest.http`, `reviewApiTest.http` 파일을 사용해 api를 실행합니다.

