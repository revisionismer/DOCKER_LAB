# 내려받을 도커 컨테이너:태그 명
FROM openjdk:11-jdk-slim  

# WORKDIR : 터미널로 접근 시 첫 경로 지정(현재 폴더 경로)
WORKDIR /app

# TIP : ADD 압축파일.zip -> 압축이 풀린다.
# build 폴더 안에 aws-v3-.0.0.3.jar 파일을 ./ -> WORKDIR로 지정한 시작 폴더 경로 + 지정 한 파일명으로 복사
COPY build/aws-v3-0.0.3.jar ./application.jar

# 실행할 명령어 입력
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "application.jar"]

# 엔트리포인트 옵션
CMD ["--server.port=3000"]
