FROM openjdk:8-jre-alpine
LABEL organization="NIEHS"
LABEL maintainer="michael.c.conway@gmail.com"
LABEL description="iRODS Metadata Template REST endpoint"
ADD runit.sh /

ADD MetadataTemplateService.jar /
CMD ["/runit.sh"]



# build: docker build -t diceunc/metadata-templates-rest:latest .
