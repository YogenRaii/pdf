#!/bin/bash
#
export DEBIAN_FRONTEND=noninteractive

sudo apt-get update

sudo apt-get -y install tomcat7

# update user and group
sudo sed -i 's/TOMCAT7_USER/#TOMCAT7_USER/g' /etc/default/tomcat7
sudo sed -i 's/TOMCAT7_GROUP/#TOMCAT7_GROUP/g' /etc/default/tomcat7
sudo sed -i 's/JAVA_OPTS/#JAVA_OPTS/g' /etc/default/tomcat7

# setting correct values
sudo sed -i -e '$a\TOMCAT7_USER=vagrant' /etc/default/tomcat7
sudo sed -i -e '$a\TOMCAT7_GROUP=vagrant' /etc/default/tomcat7
sudo sed -i -e '$a\JAVA_HOME=/usr/lib/jvm/java-8-oracle' /etc/default/tomcat7
sudo sed -i -e '$a\JAVA_OPTS="-Djava.security.egd=file:/dev/./urandom -Djava.awt.headless=true -Xmx1024m -XX:+UseConcMarkSweepGC"' /etc/default/tomcat7

sudo chown -R vagrant:adm /var/{lib,log}/tomcat7/
sudo chown -R vagrant:vagrant /var/lib/tomcat7/webapps
sudo chown -R vagrant:adm /var/cache/tomcat7
sudo chown -R vagrant:vagrant /var/cache/tomcat7/Catalina
sudo usermod -a -G tomcat7 vagrant

# sudo ln -s /usr/local/etc/init.d/tomcat7 /etc/init.d

# make couchdb start at runtime
sudo update-rc.d tomcat7 defaults
sudo update-rc.d tomcat7 enable

sudo service tomcat7 restart