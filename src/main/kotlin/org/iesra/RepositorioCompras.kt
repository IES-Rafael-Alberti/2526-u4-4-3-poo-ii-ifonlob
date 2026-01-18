package org.iesra

class RepositorioCompras {
    val listaCompra : MutableList<Compra> = mutableListOf<Compra>()

    fun agregar(compra: Compra){
        listaCompra.add(compra)
    }

    fun domicilios() : Set<Domicilio>{
        return listaCompra.map { it.cliente.domicilio }.toSet()
    }

}