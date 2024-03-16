# CSV Viewer

## Ejecución en macOS

### Instalación de Git (si no está instalado)

Si Git no está instalado, sigue estos pasos previos:

```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
brew install git
```

## Ejecución del proyecto

Una vez instalado Git, sigue estas instrucciones para ejecutar el proyecto:

```bash
git clone git@github.com:DSusagna/CsvViewr.git
cd CsvViewr
chmod +x runMacOS.sh
sudo ./runMacOS.sh
```

## Ejecución en Windows

### Instalación de Git (si no está instalado)

Si Git no está instalado, sigue estos pasos previos:

```bash
curl -o git-installer.exe -L https://github.com/git-for-windows/git/releases/download/v2.35.1.windows.2/Git-2.35.1.2-64-bit.exe
git-installer.exe /SILENT
del git-installer.exe
```

## Ejecución del proyecto

Una vez instalado Git, ejecuta las siguientes líneas en la terminal:

```bash
git clone git@github.com:DSusagna/CsvViewr.git
cd CsvViewr
call runWindows.bat
```
