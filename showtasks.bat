call runcrud.bat
if "%ERRORLEVEL%" == "0" goto getTasks
goto fail

:getTasks
start firefox http://localhost:8080/crud/v1/task/getTasks

:fail
exit
