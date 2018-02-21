#!/usr/bin/env python3
import subprocess

outs = subprocess.getstatusoutput("mvn clean package")
if outs is None or outs[0] != 0:
  print(outs)
  # raise outs[1]

print(outs[1], "\n")

outs = subprocess.getstatusoutput("java -jar target/gs-rest-service-0.1.0.jar")
if outs is None or outs[0] != 0:
  print(outs)
  # raise outs[1]

print(outs[1], "\n")
