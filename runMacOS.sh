#!/bin/bash

# Función para verificar si el JDK está instalado
check_java() {
    if ! command -v java &> /dev/null; then
        return 1
    fi
    return 0
}

# Función para instalar el JDK utilizando Homebrew
install_java() {
    echo "JDK no está instalado. Instalando JDK..."
    brew update
    brew tap adoptopenjdk/openjdk
    brew install --cask adoptopenjdk
}

# Verificar si Java está instalado
if check_java; then
    echo "JDK está instalado."
else
    install_java
fi

# Ejecutar el archivo .jar
echo "Ejecutando CsvViewr.jar..."
java -jar "$PWD/artifacts/CsvViewr.jar"
