@echo off

rem ======================================================================
rem mvn package script
rem default dev profile
rem
rem author: lksoulman
rem date: 2019-01-09
rem ======================================================================

set PROFILE=%1
if "%PROFILE%" == "" (
    echo profile:dev
    mvn clean package -Pdev -DskipTests
    echo profile:dev
    pause
) else (
    echo profile:%PROFILE%
    mvn clean package -P%PROFILE% -DskipTests
    echo profile:%PROFILE%
    pause
)