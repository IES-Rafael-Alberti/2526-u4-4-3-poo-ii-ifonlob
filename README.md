# Práctica 4.3: Programación orientada a objetos II

# Título de la Actividad

## Identificación de la Actividad

- **Módulo:** PROG
- **Unidad de Trabajo:** U4 - POO II
- **Fecha de Creación:** 18/01/2026
- **Fecha de Entrega:** 23/01/2026
- **Alumno(s):**
    - **Nombre y Apellidos:** Irene Foncubierta Lobatón
    - **Correo electrónico:** ifonlob1108@g.educaand.es
    - **Iniciales del Alumno/Grupo:** IFL

## Descripción de la Actividad

En esta actividad he resuelto los ejercicios del  4.6 a 4.10 de POO II en Kotlin, aplicando clases, data classes, arrays, métodos estáticos (companion objects), encapsulación y validación de estados.
Asimismo, los ejercicios tratan sobre un pequeño repositorio de compras (4.6), la gestión de una persona con varias cuentas bancarias y operaciones (4.7), un conjunto de libros con calificaciones (4.8), un gestor de lista de tareas con menú interactivo (4.9) y un juego completo de tres en raya en consola con control de errores (4.10).

## Instrucciones de Compilación y Ejecución

1. **Requisitos Previos:**
    - Lenguaje: Kotlin (versión 1.9.x o compatible).
    - JDK 17 o superior instalado.
    - Opcional: IntelliJ IDEA con soporte Kotlin para ejecutar desde el IDE.
2. **Compilación (terminal, proyecto simple):**

```bash
kotlinc -include-runtime -d practica4_3.jar src/main/kotlin/org/iesra/*.kt
```

3. **Ejecución del programa principal (ejercicios 4.7–4.9):**

```bash
java -jar practica4_3.jar
```

En el `main` de `Main.kt` se ejecutan todas las pruebas de los siguientes ejercicios: la cuenta/persona (4.7), del conjunto de libros (4.8) y abre el menú de lista de tareas (4.9).
4. **Ejecución del Tres en raya (4.10):**
    - Ejecutar la función `main` de `MainTresEnRaya.kt` desde el IDE, o bien compilarla en otro JAR si se separa del principal.
    - El programa pedirá coordenadas `fila,columna` para jugador 1 (cruces) y jugador 2 (círculos).

## Desarrollo de la Actividad

### Ejercicio 4.6 – Repositorio de compras

En este ejercicio se modelan las compras como composición de cliente y domicilio usando **data classes** para `Compra`, `Cliente` y `Domicilio`, y se implementa un repositorio que devuelve los domicilios únicos donde enviar facturas.
La clase `Domicilio` incluye un método `dirCompleta()` que concatena calle y número, mientras que `RepositorioCompras` mantiene una lista mutable de compras y ofrece un método `domicilios()` que genera un `Set` con los domicilios distintos de los clientes.

- `Domicilio.kt` – data class con `calle`, `numero` y método `dirCompleta()`.
- `Cliente.kt` – data class con `nombre` y `domicilio`.
- `Compra.kt` – data class con `cliente`, `dia` y `monto`.
- `RepositorioCompras.kt` – lista interna de compras y métodos `agregar` y `domicilios`.


### Ejercicio 4.7 – Persona y cuentas bancarias

Se crea la clase `Cuenta` con número y saldo, con operaciones para consultar saldo, recibir abonos y realizar pagos, además de un companion object con los métodos estáticos `esMorosa` y `transferencia` que trabajan sobre objetos `Persona` y sus cuentas.
La clase `Persona` mantiene un `Array<Cuenta?>` de tamaño 3 como máximo, un contador `numCuentas` y un método `añadirCuenta` que añade cuentas hasta el límite devolviendo un booleano según éxito o fallo.

- `Cuenta.kt` – métodos de negocio, validación de saldo y métodos estáticos de morosidad y transferencia entre cuentas por índice.
- `Persona.kt` – gestión de hasta 3 cuentas bancarias en array, con control de capacidad.

En `Main.kt` se crea una persona con dos cuentas, se ingresa la nómina en una de ellas, se paga el alquiler con la otra, se comprueba si es morosa y se realiza una transferencia para dejar todos los saldos en positivo, mostrando el resultado final por consola.

### Ejercicio 4.8 – Conjunto de libros

Este ejercicio gestiona un conjunto de libros leídos con calificación, modelando cada libro con título, autor, número de páginas y calificación de 0 a 10.
`ConjuntoLibros` utiliza un array fijo de tamaño 5 para almacenar libros, métodos para añadir sin duplicar título, eliminar por título o autor, y mostrar por consola el libro con mayor y menor calificación, además de un listado completo del conjunto.

- `Libro.kt` – data class que almacena los datos del libro y su calificación.
- `ConjuntoLibros.kt` – lógica de almacenamiento, búsqueda y estadísticas de calificación.

En el `main` se crean dos libros, se añaden al conjunto, se muestran máximos y mínimos, se eliminan por título y autor hasta vaciar el conjunto, se añade un nuevo libro y se vuelve a mostrar el contenido.

### Ejercicio 4.9 – Lista de tareas con estados y fechas

Para la gestión de tareas se define una enum `EstadoTarea` con estados `PENDIENTE` y `REALIZADA`, y una clase `Tarea` con id, descripción, estado y fecha de realización (opcional) que se rellena automáticamente cuando el estado pasa a realizada.
`ConjuntoTareas` mantiene una lista mutable de tareas y ofrece métodos para añadir, eliminar, cambiar el estado (marcando la fecha con `LocalDateTime.now()`), mostrar todas, mostrar solo pendientes o solo realizadas, trabajando siempre con la lista interna.

El `Main.kt` presenta un menú interactivo por consola que permite al usuario: crear tareas con id aleatorio, eliminarlas por id, cambiar su estado, listar todas las tareas o filtrar por pendientes/realizadas hasta que se pulse Enter en blanco para salir.

### Ejercicio 4.10 – Juego del 3 en raya

Para el juego del tres en raya he decidido utilizar un enum `TipoFicha` (CRUZ, CIRCULO, VACIO), una clase `Jugador` que almacena el tipo de ficha y una clase `Partida` que mantiene el tablero como lista de listas y encapsula la lógica de un turno y la detección de ganador.
`Partida` implementa `jugarTurno` con validación de coordenadas y casillas ocupadas, `mostrarTablero` para imprimir el tablero con X y O, y `determinarGanador` para comprobar filas, columnas, diagonales y empates, devolviendo un par con la ficha ganadora y un booleano de si la partida ha terminado.

`MainTresEnRaya.kt` se encarga del flujo de juego: pide coordenadas a cada jugador en formato `fila,columna`, valida formato y tipos, captura excepciones `IllegalArgumentException` para informar de errores y vuelve a pedir jugada, mostrando el tablero después de cada movimiento hasta que se detecta ganador o empate.

## Código fuente

- `src/main/kotlin/org/iesra/Main.kt` – Programa principal ejercicios 4.7–4.9.
- `src/main/kotlin/org/iesra/MainTresEnRaya.kt` – Programa principal ejercicio 4.10.
- Compras (4.6): `Domicilio.kt`, `Cliente.kt`, `Compra.kt`, `RepositorioCompras.kt`.
- Cuentas (4.7): `Cuenta.kt`, `Persona.kt`.
- Libros (4.8): `Libro.kt`, `ConjuntoLibros.kt`.
- Tareas (4.9): `EstadoTarea.kt`, `Tarea.kt`, `ConjuntoTareas.kt`.
- Tres en raya (4.10): `TipoFicha.kt`, `Jugador.kt`, `Partida.kt`, `MainTresEnRaya.kt`.

## Ejemplos de ejecución

- **Ejercicio 4.7:**
    - Se muestra por pantalla si la persona es “Es morosa” o “No es morosa” tras los abonos y pagos, y luego los saldos de ambas cuentas después de la transferencia.
- **Ejercicio 4.8:**
    - Se imprime el libro con mayor y menor calificación y el listado del conjunto antes y después de eliminar y volver a añadir libros.
- **Ejercicio 4.9:**
    - El menú permite ir añadiendo tareas, cambiando estados y listando pendientes o realizadas, mostrando cada tarea con su estado y, en las realizadas, con la fecha formateada `dd-MM-yyyy HH:mm:ss`.
- **Ejercicio 4.10:**
    - El programa alterna turnos entre cruces y círculos, muestra el tablero tras cada movimiento y finalmente indica si han ganado “las cruces”, “los círculos” o si ha habido empate.

## Resultados de pruebas

He llevado a cabo la verificación de forma manual creando objetos con distintos datos, probando casos límite como arrays llenos, títulos o autores inexistentes, tareas en distintas combinaciones de estado y jugadas inválidas en el tres en raya (coordenadas fuera de rango o casillas ocupadas), comprobando que se muestran mensajes de error adecuados o resultados correctos en cada caso.
