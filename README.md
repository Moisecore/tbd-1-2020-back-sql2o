# Respositorio Backend App Voluntariado 

## Taller de Bases de Datos

### Grupo 6
* Francisco Rousseau
* Moisés García
* Sebastián Potocnjak
* Ricardo Ruz

### Ejecución:

* IDLE recomendado -> IntelliJ o VSCode

1. Levantar servidor PostgreSQL 12
2. Clonar el repositorio
3. Completar credenciales en "src/main/resources/Application.properties"
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

* "/" -> Index temporal que sirve de guía para los entregables del Sprint 1
* "/Entidad/" -> Lista de todos los elementos activos de dicha entidad (Read)
* "/Entidad/edit/id" -> Formulario que permite crear o editar, en caso de existir, una entidad (Create, Update)
* "/Entidad/softdelete/id" -> Vista que confirma la eliminacion suave (desactivacion) de una entidad (Delete)
* "/Entidad/delete/id" -> Vista que confirma la eliminacion real de una entidad (Delete)
