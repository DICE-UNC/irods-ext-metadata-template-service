#!/bin/bash
docker run -i -t \
-p 8080:8080 \
-v /Users/conwaymc/Documents/docker/ml_dfc/etc/irods-ext:/etc/irods-ext \
diceunc/metalnx:latest
