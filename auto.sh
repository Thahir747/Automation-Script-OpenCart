#!/bin/bash

git add .
git commit -m "Updated on: $(TZ='Asia/Kolkata' date +'%Y-%m-%d %H:%M:%S')"
git pull --rebase origin main
git push origin main