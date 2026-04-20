# Trabajo Recuperación RA2 - PMDM

## Descripción

Este proyecto consiste en una aplicación móvil desarrollada en Kotlin con Jetpack Compose para gestionar notas.

---

## Objetivo

El objetivo del proyecto es poner en práctica los conceptos de Jetpack Compose y desarrollar una aplicación funcional en Android.

---

## Qué incluye la aplicación

La aplicación permite realizar las siguientes acciones:

### Gestión de notas

- Crear notas
- Editar notas
- Eliminar notas
- Ver el detalle de cada nota

### Interfaz y navegación

- Navegación con Bottom Navigation
- Navigation Drawer lateral
- Pantalla de formulario con validación
- Pantalla de información de la app

### Componentes utilizados

- Cards para mostrar notas
- Botones (Button, OutlinedButton, TextButton)
- FloatingActionButton (FAB)
- Snackbar para notificaciones

---

## Tecnologías utilizadas

- Kotlin
- Jetpack Compose
- Material Design 3
- Navigation Compose

---

## Cómo ejecutar la aplicación

1. Abrir el proyecto en Android Studio
2. Ejecutar la aplicación en un emulador o dispositivo físico

---

## Estructura del proyecto

```
TrabajoRecuperacionT1_RA2_PMMD/
├── components/
│   └── NoteCard.kt
├── data/
│   └── NoteRepository.kt
├── model/
│   └── Note.kt
├── navigation/
│   └── NavGraph.kt
├── screens/
│   ├── HomeScreen.kt
│   ├── FormScreen.kt
│   ├── DetailScreen.kt
│   └── InfoScreen.kt
├── ui.theme/
│   ├── Color.kt
│   ├── Theme.kt
│   └── Type.kt
└── MainActivity.kt
```

## Autor

Ximena Meyzen Calderón