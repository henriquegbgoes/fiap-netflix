#!/bin/bash

data=$1
url=http://localhost:8080/kafka/usuario/chamado/Test

curl -d "$data" -H "Content-Type: application/json" -X GET ${url}
