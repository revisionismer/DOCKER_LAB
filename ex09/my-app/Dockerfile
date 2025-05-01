## 1.
#FROM nginx

#RUN apt-get update

#COPY build /usr/share/nginx/html

#ENTRYPOINT ["nginx", "-g", "daemon off;"]

## 2.
FROM node:alpine AS build
WORKDIR /app
COPY package.json /app
RUN npm install --silent
COPY . /app

RUN npm run build

FROM nginx
COPY --from=build /app/build /usr/share/nginx/html

# 내가 만든 nginx.conf로 교체
COPY ./nginx/nginx.conf /etc/nginx/nginx.conf

ENTRYPOINT ["nginx", "-g", "daemon off;"]