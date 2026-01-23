package org.iesra

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Tarea(val id : Int ,val descripcion : String ) {
    var fechaHoraRealizacion: LocalDateTime? = null
    var estado : EstadoTarea = EstadoTarea.PENDIENTE
        set(value) {
            if(value == EstadoTarea.REALIZADA) {
                fechaHoraRealizacion = LocalDateTime.now()
            }
            field = value
        }
    override fun toString(): String {
        return if (estado == EstadoTarea.PENDIENTE) {
            "Tarea pendiente por hacer con ID $id: $descripcion"
        }
        else {
            val formateadorFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
            val fechaFormateada = fechaHoraRealizacion?.format(formateadorFecha) ?: "sin fecha"
            "Tarea realizada con ID $id: $descripcion el $fechaFormateada]"
        }
    }
}