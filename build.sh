#!/bin/bash
set -e

lein uberjar
native-image -jar target/uberjar/plis-0.1.0-SNAPSHOT-standalone.jar -H:Name=plis
