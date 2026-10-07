# CRUD de Artículos y Pedidos

## Objetivo del proyecto

Este proyecto tiene como finalidad gestionar un sistema básico de inventario y ventas mediante una aplicación de consola en Java. Permite registrar, listar, consultar, modificar y eliminar artículos, así como crear y listar pedidos asociados a esos artículos.

La aplicación está pensada para practicar conceptos de:

- Programación orientada a objetos
- Herencia y polimorfismo
- CRUD en memoria
- Validación de datos por consola
- Manejo de listas y objetos en Java

## Funcionamiento

La aplicación inicia desde la clase `App`, donde se muestra un menú principal con las siguientes opciones:

1. Artículos
2. Pedidos
3. Salir

### Menú de artículos

Dentro de la sección de artículos, se pueden realizar las siguientes acciones:

- Crear artículo
- Listar todos los artículos
- Consultar un artículo por ID
- Modificar un artículo
- Eliminar un artículo
- Volver al menú principal

Los artículos pueden ser de dos tipos:

- Electrónicos
- Alimenticios

Cada tipo tiene atributos específicos:

- Electrónico: garantía en meses
- Alimenticio: días hasta vencimiento

### Menú de pedidos

Dentro de la sección de pedidos, se pueden realizar las siguientes acciones:

- Crear pedido
- Listar todos los pedidos
- Volver al menú principal

Un pedido se asocia a:

- un artículo existente
- una cantidad solicitada
- un ID de pedido

Antes de crear un pedido, la aplicación valida que el artículo exista y que la cantidad solicitada no supere el stock disponible.

## Flujo general de uso

1. Ejecutar la aplicación desde `App.java`.
2. Elegir si se desea trabajar con artículos o pedidos.
3. Seleccionar la operación a realizar.
4. Ingresar los datos solicitados por consola.
5. Repetir la operación hasta salir del sistema.

## Estructura del proyecto

- `src/App.java`: punto de entrada de la aplicación
- `src/model`: modelos de datos (`Articulo`, `Pedido`, `ArticuloElectronico`, `ArticuloAlimenticio`)
- `src/service`: lógica de negocio para artículos y pedidos
- `src/utils/Utils.java`: métodos reutilizables para entrada y validación

## Ejecución

Desde la terminal, puedes compilar y ejecutar el proyecto con:

```bash
javac -d out $(find src -name "*.java")
java -cp out App
```

## Nota

Este proyecto es una práctica de consola simple, sin persistencia en base de datos ni interfaz gráfica, y su objetivo principal es demostrar el uso de CRUD y estructuras de objetos en Java.
