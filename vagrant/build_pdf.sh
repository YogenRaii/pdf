#!/bin/bash
#

VAGRANT_DIR=`pwd`

cd ..

mvn clean package -Dmaven.test.skip=true

rm -rf $VAGRANT_DIR/artifacts/pdf-app*
cp pdf-app/target/*.war $VAGRANT_DIR/artifacts
