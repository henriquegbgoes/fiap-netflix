#!/bin/bash

data=$1
url=http://localhost:8080/ticket

curl -d "$data" -H "Content-Type: application/json" -X POST ${url}
