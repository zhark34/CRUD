# CRUD de Artículos

## Objetivo del proyecto

Este proyecto tiene como finalidad gestionar un sistema básico de artículos mediante una aplicación de consola en Java. Permite registrar, listar, consultar, modificar y eliminar artículos.

La aplicación está pensada para practicar conceptos de:

- Programación orientada a objetos
- Herencia y polimorfismo
- CRUD en memoria
- Validación de datos por consola
- Manejo de listas y objetos en Java

## Funcionamiento

La aplicación inicia desde la clase `App`, donde se muestra el menú principal con las siguientes acciones:

1. Crear artículo
2. Listar todos los artículos
3. Consultar un artículo por código
4. Modificar un artículo
5. Eliminar un artículo
6. Listar categorías
0. Salir

Las categorías disponibles se precargan al iniciar la aplicación y se pueden asociar a los artículos. También pueden listarse desde el menú. Los artículos pueden ser de dos tipos:

- Electrónicos
- Alimenticios

Cada tipo tiene atributos específicos:

- Electrónico: garantía en meses
- Alimenticio: días hasta vencimiento

## Estado y limitaciones conocidas

- Los artículos se almacenan en memoria y se pierden al cerrar la aplicación.
- El detalle específico de cada subtipo está disponible en `getDetalleEspecifico()`, pero todavía no se incluye en la representación de `toString()` que muestran los listados y consultas.
- En la modificación de artículos alimenticios, la opción de salida que muestra el menú no coincide con la condición del ciclo y el menú puede quedar activo.
- La edición no impide asignar valores negativos a garantía o vencimiento; tampoco permite cambiar la categoría de un artículo alimenticio.
- Algunas entradas no numéricas en los selectores de tipo o categoría durante la edición pueden interrumpir la operación con una excepción.

## Flujo general de uso

1. Ejecutar la aplicación desde `App.java`.
2. Seleccionar una operación del menú de artículos.
3. Ingresar los datos solicitados por consola.
4. Repetir la operación hasta salir del sistema.

## Estructura del proyecto

- `src/App.java`: punto de entrada de la aplicación
- `src/model`: modelos de datos (`Articulo`, `Categoria`, `ArticuloElectronico`, `ArticuloAlimenticio`)
- `src/service`: lógica de negocio para artículos
- `src/utils/Utils.java`: métodos reutilizables para entrada y validación

## Ejecución

Desde la terminal, puedes compilar y ejecutar el proyecto con:

```bash
javac -d out $(find src -name "*.java")
java -cp out App
```

## Nota

Este proyecto es una práctica de consola simple, sin persistencia en base de datos ni interfaz gráfica, y su objetivo principal es demostrar el uso de CRUD y estructuras de objetos en Java.
