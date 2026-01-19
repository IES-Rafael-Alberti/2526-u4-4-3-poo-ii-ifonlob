package org.iesra

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Tarea(val id : String ,val descripcion : String ) {
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
            "Tarea $id: $descripcion [PENDIENTE]"
        }
        else {
            val formateadorFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
            val fechaFormateada = fechaHoraRealizacion?.format(formateadorFecha) ?: "sin fecha"
            "Tarea $id: $descripcion [REALIZADA el $fechaFormateada]"
        }
    }
}