FROM nginx

# RUN apt-get update

COPY webapp /usr/share/nginx/html
COPY conf/nginx.conf /etc/nginx/conf.d/default.conf

ENTRYPOINT ["nginx", "-g", "daemon off;"]
