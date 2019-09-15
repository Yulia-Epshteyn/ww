#!/bin/bash

BUILD_DIR=build/q2
SRC_DIR=src/ww/q2
TEST_DIR=tst/ww/q2
DEPENDENCIES=lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar:lib/client-combined-3.141.59.jar:lib/byte-buddy-1.8.15.jar:lib/okhttp-3.11.0.jar:lib/okio-1.14.0.jar:lib/commons-exec-1.3.jar:lib/guava-25.0-jre.jar

mkdir -p ${BUILD_DIR}

javac -d ${BUILD_DIR} -cp ${DEPENDENCIES} ${SRC_DIR}/BasePage.java ${SRC_DIR}/IndexPage.java ${SRC_DIR}/FindStudioPage.java {TEST_DIR}/WWTest.java
java -cp ${BUILD_DIR}:${DEPENDENCIES} org.junit.runner.JUnitCore ww.q2.WWTest