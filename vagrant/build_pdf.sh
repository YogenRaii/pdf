#!/bin/bash
#

VAGRANT_DIR=`pwd`

cd ..

mvn clean package -Dmaven.test.skip=true

rm -rf $VAGRANT_DIR/artifacts/pdf-app*
cp opensrp-web/target/pdf.war $VAGRANT_DIR/artifacts
