#!/usr/bin/env bash

version=$1

LIB=./lib/

if [[ ! -e ${LIB} ]]; then
	mkdir ${LIB}
fi

cp ./client/target/lib/*.jar ./lib/
cp ./client/target/client-${version}.jar ./

java -jar ./client-${version}.jar \
	localhost 45
