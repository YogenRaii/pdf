#!/bin/bash
#

# update repositories
sudo apt-get update

# install java 8
echo "Installing Java..."
sudo wget --no-check-certificate https://github.com/aglover/ubuntu-equip/raw/master/equip_java8.sh && bash equip_java8.sh

# install common dependencies and tools
echo "Installing common dependencies..."
sudo apt-get -y install vim git zip unzip dnsmasq

# Set up dnsmasq
echo "Configuring common..."
sudo cp ${VAGRANT_DIR}/files/common/dnsmasq.conf /etc/dnsmasq.conf
sudo cp ${VAGRANT_DIR}/files/common/private_resolv.conf /etc/private_resolv.conf

echo "Starting Dnsmasq..."
sudo /usr/sbin/service dnsmasq restart

# install curl
sudo apt-get install curl

# install maven
sudo apt update
sudo apt install maven