# Laboratorio 1 Taller de Base de Datos
## Contexto
> En nuestro país, con la ocurrencia de desastres naturales, se da con frecuencia que voluntarios concurren espontáneamente al sitio del suceso. Si bien su presencia es de gran ayuda, puede resultar difícil coordinar sus esfuerzos para la realización de tareas. Para este fin, se propone crear un sistema para la gestión del voluntariado espontáneo.
El sistema de voluntariado debe estar asociado a una institución de voluntariado. En cada institución hay coordinadores que decretan emergencias para iniciar el reclutamiento de voluntarios. En estas emergencias se definen requisitos para los voluntarios (por ejemplo: los voluntarios deben tener determinado equipamiento, salud compatible, etc).
Posteriormente los voluntarios seleccionados serán rankeados según estos requisitos, voluntarios con mayor número de requisitos tienen mayor ranking. Los voluntarios declaran su disponibilidad para ser reclutados a una emergencia. Una vez que son contactados, el coordinador les asigna tareas. Los voluntarios finalmente actualizan el estado de las tareas, para ser consultados por el coordinador.

## Equipo de trabajo

- Integrantes:
    - Luis Mellado (Backend)
    - Karen Garrido (Backend)
    - Aldo Castillo (Frontend)
    - Eduardo Abarca (Frontend)
 - Semestre: 2-2022
 - Fecha de entrega: 09/10/2022

## Manual de instalación

Las siguientes subsecciones tienen por objetivo presentar el conjunto de instrucciones necesario para poder ejecutar el proyecto contenido en este repositorio. Es necesario seguir el orden en el cuál se presentan, pues cada paso requiere que los anteriores se hayan completado satisfactoriamente.

### Programas necesarios a instalar
 - PostgreSQL, versión 12.0
 - SpringToolSuite4 o Visual Studio Code, con extensión "Gradle for Java"
 - Npm, versión 8.12.1
 - Node.js, versión 16.14.2

### Configurar usuario de PostgreSQL 'postgres' y crear base de datos 'lab1'

1. Windows
```bash
# Abrir cmd o PowerShell, conectarse a psql (Si no se ha manipulado el usuario 'postgres' anteriormente, presionar enter bastará)
$ psql -U postgres

# Asignar contraseña 'postgres' a usuario postgres
$ ALTER USER postgres WITH PASSWORD 'postgres';

# Crear base de datos que usará el proyecto
$ CREATE DATABASE lab1;

# Cerrar terminal psql
$ \q
```

2. Sistemas Debian (Ubuntu)
```bash
# Abrir terminal, cambiar de usuario (ingresar, luego de este comando, la contraseña asignada para el usuario que ejecuta)
$ sudo -i -u postgres

# Conectarse a psql (Si no se ha manipulado el usuario 'postgres' anteriormente, presionar enter bastará)
$ psql -U postgres

# Asignar contraseña 'postgres' a usuario postgres
$ ALTER USER postgres WITH PASSWORD 'postgres';

# Crear base de datos que usará el proyecto
$ CREATE DATABASE lab1;

# Cerrar terminal psql
$ \q

# Salir de usuario postgres en terminal
$ exit
```

### Ejecutar back-end

```bash
# Dirigirse a directorio de aplicación back-end desde terminal (Se asume ubicación en Escritorio ('escritorio'))
$ cd /escritorio/Grupo2_Lab1_TBD/lab1_backend

# Ejecutar el proyecto, cuyo acceso será: http://localhost:3000
$ ./gradlew bootRun
```

### Ejecutar front-end

```bash
# Dirigirse a directorio de aplicación front-end desde terminal (Se asume ubicación en Escritorio ('escritorio'))
$ cd /escritorio/Grupo2_Lab1_TBD/lab1_frontend

# Instalar dependencias necesarias para la ejecución
$ npm install

# Ejecutar el proyecto, cuyo acceso será: http://localhost:8080
$ npm run dev

# Acceder a la vista del proyecto, ingresando en su navegador de preferencia la URL presentada en el paso anterior
```