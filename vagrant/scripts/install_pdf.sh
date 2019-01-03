#!/bin/bash
#

# copy custom alfresco.war
echo "Installing custom pdf war..."
sudo cp /vagrant/artifacts/pdf-app-*.war /var/lib/tomcat7/webapps/pdf.war