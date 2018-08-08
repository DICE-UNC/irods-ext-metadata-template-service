FROM openjdk:8-jre-alpine
LABEL organization="NIEHS"
LABEL maintainer="michael.c.conway@gmail.com"
LABEL description="iRODS Metadata Template REST endpoint"
ADD runit.sh /

ADD target/metadata-template-rest.jar /
CMD ["/runit.sh"]

# build: docker build -t diceunc/metadata-template-rest:latest .
