#!/bin/bash
#
export VAGRANT_DIR=/vagrant
. ${VAGRANT_DIR}/scripts/install_commons.sh
. ${VAGRANT_DIR}/scripts/install_mysql.sh
. ${VAGRANT_DIR}/scripts/install_tomcat.sh
. ${VAGRANT_DIR}/scripts/install_pdf.sh