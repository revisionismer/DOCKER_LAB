# 도커 파일 생성해서 하단에 CRLF(Carriage Return Line Feed)를 LF(Line Feed)로 변경 후 저장한다음 시작
FROM mysql:8.0

# COPY가 제대로 안될때 해당 파일 권한 부여
RUN chmod 755 /docker-entrypoint-initdb.d

COPY init.sql /docker-entrypoint-initdb.d

ENV MYSQL_ROOT_PASSWORD=root1234
ENV MYSQL_DATABASE=metadb
ENV MYSQL_HOST=%

CMD ["--character-set-server=utf8mb4", "--collation-server=utf8mb4_unicode_ci"]