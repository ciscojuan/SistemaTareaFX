# Sistema de Tareas con Spring y JavaFX

Esta aplicación permite la gestión de tareas por realizar, incluyendo:

-   **Visualización:** Muestra una tabla con las tareas, su responsable y estado actual (pendiente, realizada o en progreso).
-   **Monitoreo:** Permite realizar un seguimiento del progreso de las tareas, identificando las que ya se han completado, las que están en curso y las que aún no se han echo.

**Tecnologías:**

-   **Java:** Lenguaje de programación principal utilizado para desarrollar la aplicación.
-   **Spring:** Framework de desarrollo Java que facilita la creación de aplicaciones web y de escritorio. En este proyecto, se utiliza para:
    
    -   **Configuración:** Gestionar la configuración de la aplicación, como la conexión a la base de datos.
    -   **Inyección de dependencias:** Facilitar la creación y gestión de objetos que la aplicación necesita.
    -   **Acceso a datos:** Implementar la capa de acceso a datos, utilizando Hibernate.
    
-   **Hibernate:** Framework de mapeo objeto-relacional (ORM) que facilita la persistencia de datos en una base de datos. En este proyecto, se utiliza para:
    
    -   **Mapeo de objetos:** Convertir objetos Java en entidades de la base de datos y viceversa.
    -   **Consultas:** Realizar consultas a la base de datos para recuperar y actualizar información.
    
-   **JavaFX:** Framework para la creación de interfaces gráficas de usuario (GUI) en Java. En este proyecto, se utiliza para:
    -   **Diseño de la interfaz:** Crear la interfaz gráfica de usuario de la aplicación, incluyendo la tabla, los botones y los formularios.
    -   **Interacción con el usuario:** Gestionar la interacción del usuario con la aplicación, como la creación, edición y eliminación de tareas.
    
## Diagrama de clases
```mermaid
classDiagram
	class TareasApplication {
		+ main(String[] args)
	}

		class SistemasTareasFX {
		+ init()
		+ start(Stage stage)
		+ stop()
	}

	class IndexController {
		+ logger: Logger
		+ tareaServicio: TareaServicio
		+ tareaTabla: TableView
		+ idColumn: TableView<Tarea>
		+ todoColumn: TableColumn
		+ responsibleColumn: TableColumn
		+ statusColumn: TableColumn
		+ nombreTarea: TextField
		+ responsibleTarea: TextField
		+ statusTarea: TextField
		+ initialize(URL location, ResourceBundle resources)
		+ configurarColumnas()
		+ listarTareas()
		+ agregarTarea()
		+ cargarRegistro()
		+ editarTarea()
		+ eliminarTarea()
	}

	class TareaServicio {
		+ getTareas(): List<Tarea>
		+ getTarea(Integer tareaId): Tarea
		+ addTarea(Tarea tarea)
		+ deleteTarea(Tarea tarea)
	}

	class ITareaServicio {
	<< interface>>
		+ getTareas(): List<Tarea>
		+ getTarea(Integer tareaId): Tarea
		+ addTarea(Tarea tarea)
		+ deleteTarea(Tarea tarea)
	}

	class TareaRepository {
		+ findAll(): List<Tarea>
		+ findById(Integer tareaId): Tarea
		+ save(Tarea tarea)
		+ delete(Tarea tarea)
	}

	class Tarea {
		+ tareaId: Integer
		+ nombre: String
		+ responsable: String
		+ status: String
	}

TareasApplication --> SistemasTareasFX
SistemasTareasFX --> IndexController
IndexController --> TareaServicio
TareaServicio --> TareaRepository
IndexController --> Tarea


```

##  Estructura del Proyecto
```
├── com
│ ├── tareas
| |	  ├── controller
| |   │ │ └── IndexController.java
| |	  |	│ ├── models
| |	  |	│ │ └── Tarea.java
| |	  |	│ ├── repositoy
| |	  |	│ │ └── TareaRepository.java
| |	  |	│ ├── services
| |	  |	│ │ ├── ITareaServicio.java 
| |	  |	│ │ └── TareaServicio.java
| |	  |	│ ├── presentaciones
| |	  |	│ │ └── SistemasTareasFX.java
│ └── TareasApplication.java
└── pom.xml
```
## Imagenes del proyecto
Sistema tareas tabla
![enter image description here](https://github.com/ciscojuan/SistemaTareaFX/blob/main/src/main/resources/images/1.png?raw=true)
Stsema Tareas Error validacion
![SistemaTareas - Error validacion](https://github.com/ciscojuan/SistemaTareaFX/blob/main/src/main/resources/images/2.png?raw=true)
Sistema Tareas tarea Agregada
![enter image description here](https://github.com/ciscojuan/SistemaTareaFX/blob/main/src/main/resources/images/3.png?raw=true)
Tarea Agregada
![Tarea Agregada](https://github.com/ciscojuan/SistemaTareaFX/blob/main/src/main/resources/images/4.png?raw=true)
Sistema Tareas tarea Modificada
![enter image description here](https://github.com/ciscojuan/SistemaTareaFX/blob/main/src/main/resources/images/5.png?raw=true)
Tarea Eliminada![Tarea Eliminada](https://github.com/ciscojuan/SistemaTareaFX/blob/main/src/main/resources/images/6.png?raw=true)
