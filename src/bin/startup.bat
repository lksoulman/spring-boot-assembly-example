@echo off
rem ======================================================================
rem windows startup script
rem
rem author: lksoulman
rem date: 2019-01-09
rem ======================================================================

rem Open in a browser
start "" "http://localhost:8080/api/hello?name=lksoulman"

rem startup jar
java -jar ../main/spring-boot-assembly-example.jar --spring.config.location=../conf/

pause