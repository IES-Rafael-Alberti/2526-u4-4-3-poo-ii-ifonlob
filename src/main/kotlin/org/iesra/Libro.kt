package org.iesra

class Libro(val titulo : String, val autor : String, val numPaginas : Int, val calificacion : Int){
    override fun toString(): String {
        return "Libro(título = $titulo de $autor, $numPaginas páginas, nota $calificacion)"
    }
}