package org.iesra

data class Domicilio(val calle : String, val numero : Int){
    fun dirCompleta() : String{
        return "$calle $numero"
    }
}
