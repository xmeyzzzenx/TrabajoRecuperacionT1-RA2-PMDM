# TrabajoRecuperacionT1-RA2-PMDM
## Autora: Ximena Meyzen Calderon - 2DAM - PMDM

---

## Descripcion

App Android desarrollada en Kotlin con Jetpack Compose para gestionar tareas.
Permite crear, editar, completar y eliminar tareas de forma sencilla,
con una interfaz limpia siguiendo Material Design 3.

---

## Objetivo

Poner en practica los conceptos de Jetpack Compose desarrollando una app
funcional en Android con navegacion, formularios, validacion y componentes
de Material Design 3.

---

## Que incluye la app

### Gestion de tareas

- Crear tareas con titulo y descripcion
- Editar tareas existentes
- Eliminar tareas con el boton X
- Marcar tareas como completadas o pendientes
- Ver el detalle de cada tarea

### Interfaz y navegacion

- Bottom Navigation con tres secciones
- Navigation Drawer lateral
- Formulario con validacion y Snackbar de error
- Pantalla de detalle de tarea
- Pantalla de informacion de la app

### Componentes utilizados

- OutlinedCard para mostrar las tareas con borde gris
- Button para guardar y actualizar tareas
- OutlinedButton para Ver y Editar
- TextButton para Completar/Pendiente
- FloatingActionButton para añadir tarea nueva
- Snackbar cuando los campos del formulario estan vacios
- IconButton para eliminar tarea y abrir el drawer

---

## Tecnologias utilizadas

- Kotlin
- Jetpack Compose
- Material Design 3
- Navigation Compose

---

## Como ejecutar la app

1. Abrir el proyecto en Android Studio
2. Ejecutar en un emulador o dispositivo fisico

---

## Estructura del proyecto

```
TrabajoRecuperacionT1-RA2-PMDM/
├── components/
│   └── TaskCard.kt
├── data/
│   └── TaskRepository.kt
├── model/
│   └── Task.kt
├── navigation/
│   └── NavGraph.kt
├── screens/
│   ├── HomeScreen.kt
│   ├── FormScreen.kt
│   ├── DetailScreen.kt
│   └── InfoScreen.kt
├── ui/theme/
│   ├── Color.kt
│   ├── Theme.kt
│   └── Type.kt
└── MainActivity.kt
```

---

## Repositorio

https://github.com/xmeyzzzenx/TrabajoRecuperacionT1-RA2-PMDM

---

## Autora

Ximena Meyzen Calderon
