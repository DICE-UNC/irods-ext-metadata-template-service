# irods-ext-metadata-template-service
irods-ext based metadata template service 



### Building

This is a spring boot application run as a single executable jar, therefore, to build for docker packaging, run

```
mvn package spring-boot:repackage

```

The docker image can be build using the provided Dockerfile at the root of this repo using a command such as

```
docker build -t diceunc/metadata-template-rest:latest .

```

