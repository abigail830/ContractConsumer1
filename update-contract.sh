#!/usr/bin/env bash

git submodule add https://github.com/abigail830/common-contract-files.git contracts
git submodule init
git submodule update

git submodule foreach git fetch --all
git submodule foreach git reset --hard origin/master

git submodule foreach git checkout master
git submodule foreach git pull.gitmodules