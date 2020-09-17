# Repositorio Backend App Voluntariado 

## Taller de Bases de Datos

### Grupo 6
* Moisés García
* Sebastián Potocnjak
* Ricardo Ruz

### Ejecución:

* IDLE recomendado -> IntelliJ o VSCode

1. Levantar servidor PostgreSQL 12
2. Clonar el repositorio
3. Completar credenciales en "src/main/java/com.example.tbd/repository/DatabaseContext"
-----------------------------------
#### VSCODE: (Requiere plugin de Gradle)
4. Añadir el repositorio al workspace de Vscode
5. Compilar app con Gradle (ejecutar "tbd/application/bootRun" en Gradle Tasks)
-----------------------------------
#### IntelliJ:
4. Abrir el archivo "/build.gradle" como proyecto
5. Ejecutar el codigo con el botón play
-----------------------------------
6. Abrir "Localhost:8080/"


### Mapeo de la App

* GET "/" -> Inicio
* GET "/voluntario/" -> Lista de todos los voluntarios (Read)
* GET "/voluntario/id" -> Busca un voluntario con la id especificada (Read)
* DELETE "voluntario/id" -> "Borra" un voluntario con la id especificada (Delete)
