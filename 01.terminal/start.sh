#!/bin/sh
script_abs=$(readlink -f "$0")
path=${script_abs%/bin*}

echo $path
java -jar $path/${jarname}-0.0.1.jar 1>$path/log 2>$path/log &
