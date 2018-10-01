#!/usr/bin/env bash

version=$1

LIB=./lib/

if [[ ! -e ${LIB} ]]; then
	mkdir ${LIB}
fi

cp ./server/target/lib/*.jar ./lib

cp ./server/target/server-${version}.jar ./


java  -jar ./server-${version}.jar \
	com.art2cat.dev.ServerEngine
