# 도커 파일 생성해서 하단에 CRLF(Carriage Return Line Feed)를 LF(Line Feed)로 변경 후 저장한다음 시작
FROM openjdk:11-jdk-slim

#도커 이미지에서 어디서 작업을 할지를 의미
WORKDIR /app

# COPY만 docker-compose 파일의 위치를 기반으로 작동함 : .(현재 디렉토리 : docker-test-server 폴더)를 .(WORKDIR 경로에 복사)
COPY . .

# RUN은 현재 파일의 위치를 기반으로 작동
RUN chmod +x ./gradlew
RUN ./gradlew clean build

# build를 하면 jar 파일이 2개가 생긴다.
# 그러나 build.gradle에
# jar {
#   enabled = false
# }
# 해당 설정이 있으면 jar 파일이 1개만 생성된다.

# JAR_PATH 변수 선언
ENV JAR_PATH=/app/build/libs

# RUN MV A B -> A에 있는 내용을 B로 복사
RUN mv ${JAR_PATH}/*.jar /app/app.jar

# ENTRYPOINT ["java", "-jar", "app.jar"]
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "app.jar"]