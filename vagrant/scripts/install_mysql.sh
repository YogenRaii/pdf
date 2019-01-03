#!/bin/bash
#
export DEBIAN_FRONTEND=noninteractive

echo "deb http://repo.mysql.com/apt/ubuntu/ trusty mysql-5.7" | tee -a /etc/apt/sources.list.d/mysql.list

# Update server :)
sudo apt-get update

MYSQL_PASS='Admin123'

debconf-set-selections <<< "mysql-community-server mysql-community-server/data-dir select ''"
debconf-set-selections <<< "mysql-community-server mysql-community-server/root-pass password $MYSQL_PASS"
debconf-set-selections <<< "mysql-community-server mysql-community-server/re-root-pass password $MYSQL_PASS"

apt-get install -q -y --force-yes -o Dpkg::Options::="--force-confdef" -o Dpkg::Options::="--force-confold" mysql-server

sudo sed -i 's/bind-address/#bind-address/g' /etc/mysql/mysql.conf.d/mysqld.cnf
sudo service mysql restart

#mysql -u root --password="$MYSQL_PASS" -e "CREATE DATABASE motechquartz;"
#mysql -u root --password="$MYSQL_PASS" "motechquartz" < tables_quartz_mysql.sql