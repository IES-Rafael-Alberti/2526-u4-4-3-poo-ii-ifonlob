package org.iesra
import jdk.nashorn.internal.runtime.Debug.id
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

fun main() {
    /* EJERCICIO 2 */
    val persona1 = Persona("12345678P")
    val cuenta1 = Cuenta(556456,0.0)
    val cuenta2 = Cuenta(817003,700.0)

    persona1.añadirCuenta(cuenta1)
    persona1.añadirCuenta(cuenta2)

    cuenta1.recibirAbonos(1100.0)
    cuenta2.realizarPago(750.0)
    val esMorosa = Cuenta.esMorosa(persona1)
    println(if (esMorosa) "Es morosa" else "No es morosa")

    Cuenta.transferencia(persona1,persona1,0,1, 400.0)

    println("Saldo cuenta1: ${cuenta1.consultarSaldo()}")
    println("Saldo cuenta2: ${cuenta2.consultarSaldo()}")

    /* EJERCICIO 3 */

    val conjunto = ConjuntoLibros()

    val libro1 : Libro = Libro("Blancanieves","David Millán",234,6)
    val libro2 : Libro = Libro("La Cenicienta","María Menta",136, 9)

    conjunto.añadirLibro(libro1)
    conjunto.añadirLibro(libro2)

    conjunto.mostrarMayorCalificación()
    conjunto.mostrarMenorCalificación()
    conjunto.mostrarConjunto()

    conjunto.eliminarLibroPorTitulo("La Cenicienta")

    conjunto.eliminarLibroPorAutor("David Millán")

    conjunto.mostrarConjunto()

    conjunto.añadirLibro(Libro("Pinocho", "Mario Pérez", 315, 4))
    conjunto.mostrarConjunto()

    /* EJERCICIO 4 */
    val conjuntoDeTareas : ConjuntoTareas = ConjuntoTareas()
    println("!Bienvenido/a!, a continuación tienes las opciones disponibles: (Para finalizar presione la tecla Enter sin introducir ningún dato.")
    var terminado : Boolean = false
    while (!terminado) {
        println("1) Agregar tarea\n2)Eliminar Tarea\n3)Cambiar estado de una tarea\n4)Mostrar todas las tareas\n5)Mostrar tareas pendientes\n6)Mostrar tareas ya realizadas")
        val linea = readln()
        val eleccion: Int? = linea.toIntOrNull()
        when(eleccion) {
            1 -> {
                println("Introduzca la descripción de la tarea a añadir:")
                val descripcion : String = readln()
                val id = Random.nextInt(1,9999)
                val tarea = Tarea(id, descripcion)
                conjuntoDeTareas.añadirTarea((tarea))
                println("Tarea con ID ${tarea.id} creada con éxito.")

            }
            2 -> {
                println("Introduzca el ID de la tarea a eliminar: (Si no existe no se eliminará ninguna tarea)")
                val idAEliminar : Int = readln().toIntOrNull() ?: 0
                val tareaAEliminar : Tarea? = conjuntoDeTareas.listaTareas.find { it.id == idAEliminar }
                if (tareaAEliminar != null) {
                    conjuntoDeTareas.eliminarTarea(tareaAEliminar)
                    println("Tarea eliminada.")
                } else {
                    println("No existe ninguna tarea con ese ID.")
                }
            }
            3 -> {
                println("Introduzca el ID de la tarea a modificar:")
                val idAModificar : Int = readln().toIntOrNull() ?: 0
                val tareaAModificar : Tarea? = conjuntoDeTareas.listaTareas.find { it.id == idAModificar }
                if (tareaAModificar != null) {
                    conjuntoDeTareas.modificarEstadoTarea(tareaAModificar)
                    println("Tarea modificada con éxito.")
                }
                else{
                    println("No existe ninguna tarea con ese ID.")
                }
            }
            4 -> {
                if(conjuntoDeTareas.listaTareas.isEmpty()) {
                    println("No existen tareas.")
                }
                else{
                    conjuntoDeTareas.mostrarTodasLasTareas()
                }
            }
            5 -> {
                if (conjuntoDeTareas.listaTareas.all { it.estado == EstadoTarea.REALIZADA } || conjuntoDeTareas.listaTareas.isEmpty()) {
                    println("No existen tareas pendientes.")
                } else {
                    conjuntoDeTareas.mostrarTodasLasTareas()
                }
            }
            6 -> {
                if (conjuntoDeTareas.listaTareas.all { it.estado == EstadoTarea.PENDIENTE} || conjuntoDeTareas.listaTareas.isEmpty()) {
                    println("No existen tareas por realizar.")
                } else {
                    conjuntoDeTareas.mostrarTareasRealizadas()
                }
            }
            null -> terminado = true
        }
    }
}
