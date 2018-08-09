#!/bin/bash
docker run -i -t \
-p 8080:8080 \
-v /some/local/location/etc/irods-ext:/etc/irods-ext \
diceunc/metadata-template:latest
