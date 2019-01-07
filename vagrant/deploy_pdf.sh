#!/bin/bash
#
sudo service tomcat7 stop
cd /var/lib/tomcat7/webapps
sudo rm -rf pdf pdf.war
sudo cp /vagrant/artifacts/*.war /var/lib/tomcat7/webapps/pdf.war
sudo service tomcat7 start
