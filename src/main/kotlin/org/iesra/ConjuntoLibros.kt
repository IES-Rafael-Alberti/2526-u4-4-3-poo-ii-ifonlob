package org.iesra

class ConjuntoLibros() {
    val libros: Array<Libro?> = arrayOfNulls<Libro>(5)
    var numLibros: Int = 0

    fun añadirLibro(libro: Libro): Boolean {
        if (numLibros >= libros.size) {
            return false
        }
        for (l in libros) {
            if(l != null && libro.titulo == l.titulo ) {
                return false
            }
        }
        libros[numLibros] = libro
        numLibros++
        return true
    }

    fun eliminarLibroPorAutor(autor: String): Boolean {
        if (numLibros == 0) {
            return false
        }
        for (i in libros.indices) {
            val libro = libros[i]
            if (libro != null && libro.autor == autor) {
                libros[i] = null
                numLibros--
                return true
            }
        }
        return false
    }

    fun eliminarLibroPorTitulo(titulo: String): Boolean {
        if (numLibros == 0) {
            return false
        }
        for (i in libros.indices) {
            val libro = libros[i]
            if (libro != null && libro.titulo == titulo) {
                libros[i] = null
                numLibros--
                return true
            }
        }
        return false
    }

    fun mostrarMayorCalificación(){
        var mayor : Int = 0
        var indiceLibroMayorCalificacion = 0
        for(i in libros.indices) {
            val libro = libros[i]
            if (libro != null && libro.calificacion > mayor) {
                mayor = libro.calificacion
                indiceLibroMayorCalificacion = i
            }
        }
        println("El libro con mayor calificación es : ${libros[indiceLibroMayorCalificacion]?.titulo}")
    }
    fun mostrarMenorCalificación(){
        var menor : Int = 10
        var indiceLibroMenorCalificacion = 0
        for(i in libros.indices) {
            val libro = libros[i]
            if (libro != null && libro.calificacion < menor) {
                menor = libro.calificacion
                indiceLibroMenorCalificacion = i
            }
        }
        println("El libro con menor calificación es : ${libros[indiceLibroMenorCalificacion]?.titulo}")
    }

    fun mostrarConjunto() {
        println("Conjunto de libros:\n")
        for (libro in libros) {
            if (libro != null) {
                println(libro)
            }
        }
    }

}
