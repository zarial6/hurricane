FROM openjdk:8-jdk-alpine
MAINTAINER oleg.zhymolokhov@gmail.com

WORKDIR /app

VOLUME /tmp
COPY mindmap/build/libs/mindmap-0.1.0.jar ./

ENV JAVA_OPTS=""

ENTRYPOINT exec java -jar mindmap-0.1.0.jar