#!/bin/sh
cd /home/app/api
echo 'bundle exec thin start -S /tmp/sockets/thin.sock'
bundle exec thin start -S /tmp/sockets/thin.sock
