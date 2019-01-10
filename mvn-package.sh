#! /bin/shell

#======================================================================
# mvn package script
# default dev profile
#
# author: lksoulman
# date: 2019-01-09
#======================================================================

PROFILE=$1
if [[ -z "$PROFILE" ]]; then
    PROFILE=dev
fi
echo "profile:${PROFILE}"
mvn clean package -P${PROFILE} -DskipTests
echo "profile:${PROFILE}"