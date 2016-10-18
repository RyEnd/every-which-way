@REM ----------------------------------------------------------------------------
@REM  Copyright 2001-2006 The Apache Software Foundation.
@REM
@REM  Licensed under the Apache License, Version 2.0 (the "License");
@REM  you may not use this file except in compliance with the License.
@REM  You may obtain a copy of the License at
@REM
@REM       http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM  Unless required by applicable law or agreed to in writing, software
@REM  distributed under the License is distributed on an "AS IS" BASIS,
@REM  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM  See the License for the specific language governing permissions and
@REM  limitations under the License.
@REM ----------------------------------------------------------------------------
@REM
@REM   Copyright (c) 2001-2006 The Apache Software Foundation.  All rights
@REM   reserved.

@echo off

set ERROR_CODE=0

:init
@REM Decide how to startup depending on the version of windows

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" @setlocal

@REM -- 4NT shell
if "%eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set CMD_LINE_ARGS=%*
goto WinNTGetScriptDir

@REM The 4NT Shell from jp software
:4NTArgs
set CMD_LINE_ARGS=%$
goto WinNTGetScriptDir

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto Win9xGetScriptDir
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto Win9xApp

:Win9xGetScriptDir
set SAVEDIR=%CD%
%0\
cd %0\..\.. 
set BASEDIR=%CD%
cd %SAVEDIR%
set SAVE_DIR=
goto repoSetup

:WinNTGetScriptDir
set BASEDIR=%~dp0\..

:repoSetup


if "%JAVACMD%"=="" set JAVACMD=java

if "%REPO%"=="" set REPO=%BASEDIR%\repo

set CLASSPATH="%BASEDIR%"\etc;"%REPO%"\org\eclipse\jetty\jetty-webapp\8.1.10.v20130312\jetty-webapp-8.1.10.v20130312.jar;"%REPO%"\org\eclipse\jetty\jetty-xml\8.1.10.v20130312\jetty-xml-8.1.10.v20130312.jar;"%REPO%"\org\eclipse\jetty\jetty-servlet\8.1.10.v20130312\jetty-servlet-8.1.10.v20130312.jar;"%REPO%"\org\eclipse\jetty\jetty-security\8.1.10.v20130312\jetty-security-8.1.10.v20130312.jar;"%REPO%"\org\eclipse\jetty\jetty-server\8.1.10.v20130312\jetty-server-8.1.10.v20130312.jar;"%REPO%"\org\eclipse\jetty\orbit\javax.servlet\3.0.0.v201112011016\javax.servlet-3.0.0.v201112011016.jar;"%REPO%"\org\eclipse\jetty\jetty-servlets\8.1.10.v20130312\jetty-servlets-8.1.10.v20130312.jar;"%REPO%"\org\eclipse\jetty\jetty-continuation\8.1.10.v20130312\jetty-continuation-8.1.10.v20130312.jar;"%REPO%"\org\eclipse\jetty\jetty-client\8.1.10.v20130312\jetty-client-8.1.10.v20130312.jar;"%REPO%"\org\eclipse\jetty\jetty-http\8.1.10.v20130312\jetty-http-8.1.10.v20130312.jar;"%REPO%"\org\eclipse\jetty\jetty-io\8.1.10.v20130312\jetty-io-8.1.10.v20130312.jar;"%REPO%"\org\eclipse\jetty\jetty-util\8.1.10.v20130312\jetty-util-8.1.10.v20130312.jar;"%REPO%"\org\glassfish\web\javax.servlet.jsp\2.2.3\javax.servlet.jsp-2.2.3.jar;"%REPO%"\javax\servlet\jsp\javax.servlet.jsp-api\2.2.1\javax.servlet.jsp-api-2.2.1.jar;"%REPO%"\com\ryanmolnar\angularjs-webapp\1.0-SNAPSHOT\angularjs-webapp-1.0-SNAPSHOT.jar
goto endInit

@REM Reaching here means variables are defined and arguments have been captured
:endInit

%JAVACMD% %JAVA_OPTS%  -classpath %CLASSPATH_PREFIX%;%CLASSPATH% -Dapp.name="webapp" -Dapp.repo="%REPO%" -Dapp.home="%BASEDIR%" -Dbasedir="%BASEDIR%" com.ryanmolnar.AngularJSWebApp %CMD_LINE_ARGS%
if %ERRORLEVEL% NEQ 0 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
set ERROR_CODE=%ERRORLEVEL%

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set CMD_LINE_ARGS=
goto postExec

:endNT
@REM If error code is set to 1 then the endlocal was done already in :error.
if %ERROR_CODE% EQU 0 @endlocal


:postExec

if "%FORCE_EXIT_ON_ERROR%" == "on" (
  if %ERROR_CODE% NEQ 0 exit %ERROR_CODE%
)

exit /B %ERROR_CODE%
