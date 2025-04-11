# 도커 파일 - 환경 변수 설정

1. 도커 파일 작성(MYSQL)

# BASE IMAGE

FROM mysql

# Environment Variables : ENV KEY=VALUE

ENV MYSQL_USER=ssar
ENV MYSQL_PASSWORD=ssar1234
ENV MYSQL_ROOT_PASSWORD=root1234
ENV MYSQL_DATABASE=ssardb

# option

CMD ["--character-set-server=utf8mb4", "--collation-server=utf8mb4_unicode_ci"]

2. 도커 파일 build

# 맨 뒤에 . 은 현재 도커파일이 있는 위치를 나타낸다.

- docker build -t mysql-image .

3. 도커 파일 run

# 첫번째

- docker run -d --name mysql-container mysql-image

# 두번째 : 포트 포워딩 해준 버전으로 실행

- docker run -d -p 3307:3306 --name mysql-container mysql-image

\*tip: 도커 파일에 이미 셋팅을 해놓으면 run 할때 뒤에 길게 적어 줄 필요가 없음.
ex) docker run --name some-mysql -e MYSQL_ROOT_PASSWORD_FILE=/run/secrets/mysql-root -d mysql:tag

4. 하이디SQL로 접속해본다.

# 환경변수 설정이 잘되어 있는지 확인 하는 법

(1) 툴에서 해당 DB 편집속성으로 보기
(2) SQL로 실행해서 보기

- SHOW VARIABLES LIKE 'character*set*%';
