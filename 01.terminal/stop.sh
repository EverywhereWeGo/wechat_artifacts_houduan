#!/bin/sh
pid=`ps -ef | grep ${jarname}-0.0.1.jar | grep -v grep | awk '{print $2}'`
echo $pid
kill -9 $pid
