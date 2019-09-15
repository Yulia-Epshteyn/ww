#!/bin/bash

BUILD_DIR=build/q3
SRC_DIR=src/ww/q3
TEST_DIR=tst/ww/q3
DEPENDENCIES=lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar

mkdir -p ${BUILD_DIR}

javac -d ${BUILD_DIR} -cp ${DEPENDENCIES} ${SRC_DIR}/MinInRandom.java ${TEST_DIR}/MinInRandomTest.java
java -cp ${BUILD_DIR}:${DEPENDENCIES} org.junit.runner.JUnitCore ww.q3.MinInRandomTest