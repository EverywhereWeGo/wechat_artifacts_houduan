#!/bin/sh
pid=`ps -ef | grep wechat_artifacts_houtai-0.0.1.jar | grep -v grep | awk '{print $2}'`
echo $pid
kill -9 $pid
