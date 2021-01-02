#!/bin/bash
# /opt/jdk/bin/jdeps --list-deps Hello.class -> java.base 

/opt/jdk/bin/jlink --no-header-files --no-man-pages --compress=2 --strip-debug --add-modules java.base --output jr
