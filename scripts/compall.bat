@echo off
echo "executing command mvn clean test-compile"

:: We match on all the submodules that have a '0-' in their name (not dummy proof)
:: We provide an overview of all the found submodules

SET arrow =  fb
ECHO FOUND MODULES:
CD ..
FOR /D %%i IN (*0-*) DO (
    ECHO -- Module: %%i
)

:: Wait on the user to validate the modules

ECHO ====
ECHO Ready to compile using maven?
ECHO ===
pause

:: Go to every submodule directory and execute the mvn clean test-compile command

FOR /D %%i IN (*0-*) DO (
    ECHO ==================
    ECHO Module: %%i
    ECHO ==================
    CD %%i
    mvn clean test-compile
    CD ..
    ECHO ==================
    ECHO ===== DONE =======
    ECHO ==================
)
