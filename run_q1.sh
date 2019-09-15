#!/bin/bash

BUILD_DIR=build/q1
SRC_DIR=src/ww/q1
TEST_DIR=tst/ww/q1
DEPENDENCIES=lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar

mkdir -p ${BUILD_DIR}

javac -d ${BUILD_DIR} -cp ${DEPENDENCIES} ${SRC_DIR}/DictionaryFile.java ${TEST_DIR}/DictionaryFileTest.java
java -cp ${BUILD_DIR}:${DEPENDENCIES} org.junit.runner.JUnitCore ww.q1.DictionaryFileTest