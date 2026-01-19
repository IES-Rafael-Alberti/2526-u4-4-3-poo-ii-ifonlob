package org.iesra

class ConjuntoTareas {
    val listaTareas : MutableList<Tarea> = mutableListOf()
    fun añadirTarea(tarea : Tarea) {
        listaTareas.add(tarea)
    }

    fun eliminarTarea(tarea : Tarea) {
        listaTareas.remove(tarea)
    }

    fun modificarEstadoTarea(tarea : Tarea){
        if(tarea.estado == EstadoTarea.PENDIENTE ){
            tarea.estado = EstadoTarea.REALIZADA
        }
    }

    fun mostrarTodasLasTareas(){
        for (t in listaTareas) {
            println(t)
        }
    }

    fun mostrarTareasPendientes(){
        for(t in listaTareas) {
            if(t.estado == EstadoTarea.PENDIENTE){
                println(t)
            }
        }
    }

    fun mostrarTareasRealizadas(){
        for(t in listaTareas) {
            if(t.estado == EstadoTarea.REALIZADA){
                println(t)
            }
        }
    }
}