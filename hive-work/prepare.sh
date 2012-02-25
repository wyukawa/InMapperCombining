#!/bin/sh

hive -f postdata.ddl

wget http://www.post.japanpost.jp/zipcode/dl/roman/ken_all_rome.lzh

# yum install lha -y --enablerepo=rpmforge
lha -e ken_all_rome.lzh

hive -f load.hql

