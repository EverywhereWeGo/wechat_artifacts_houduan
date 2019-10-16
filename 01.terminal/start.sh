#!/bin/sh
path=/opt/wechat_article/houduan
java -jar $path/${jarname}-0.0.1.jar 1>$path/log 2>$path/log &
