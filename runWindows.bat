@echo off

REM Función para verificar si el JDK está instalado
:check_java
java -version > nul 2>&1
if %errorlevel% neq 0 (
    goto :install_java
) else (
    echo JDK está instalado.
)

REM Función para instalar el JDK utilizando Chocolatey (opcional, si tienes Chocolatey instalado)
:install_java
echo JDK no está instalado. Instalando JDK...
REM Coloca aquí los comandos de instalación del JDK utilizando Chocolatey
goto :run_jar

REM Ejecutar el archivo .jar
:run_jar
echo Ejecutando CsvViewr.jar...
java -jar "%~dp0artifacts\CsvViewr.jar"
