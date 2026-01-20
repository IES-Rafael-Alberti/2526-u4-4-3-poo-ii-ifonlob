package org.iesra

class Partida() {

    var tablero: MutableList<MutableList<TipoFicha>> = MutableList(3) { MutableList(3) { TipoFicha.VACIO } }
    fun jugarTurno(jugador: Jugador, x: Int, y: Int) : Boolean{

        if (x !in 0..2 || y !in 0..2) {
            throw IllegalArgumentException("Coordenadas fuera de rango")
        }
        if (tablero[x][y] != TipoFicha.VACIO) {
            throw IllegalArgumentException("Has intentado colocar una ficha en una coordenada ya ocupada.")
        }
        tablero[x][y] = jugador.tipo
        val (_, terminado) = determinarGanador()
        return terminado

    }

    fun determinarGanador(): Pair<TipoFicha,Boolean> {
        // Líneas Horizontales
        for (i in 0 until tablero.size) {
            if (tablero[i].all { it == TipoFicha.CRUZ }) {
                return Pair(TipoFicha.CRUZ,true)
            }
            if (tablero[i].all { it == TipoFicha.CIRCULO }) {
                return Pair(TipoFicha.CIRCULO,true)
            }
        }
        // Líneas Verticales
        val lineaVertical : MutableList<TipoFicha> = mutableListOf()
        for (j in 0 until tablero.size) {
            for (i in 0 until tablero.size) {
                lineaVertical.add(tablero[i][j])
            }
        }
        if(lineaVertical.all{ it == TipoFicha.CRUZ }) {
            return Pair(TipoFicha.CRUZ,true)
        }
        if(lineaVertical.all{ it == TipoFicha.CIRCULO}) {
            return Pair(TipoFicha.CIRCULO,true)
            }

        // Diagonales
        if (tablero[0][0] != TipoFicha.VACIO && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            return Pair(tablero[0][0], true)
        }
        if (tablero[0][2] != TipoFicha.VACIO && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]
        ) {
            return Pair(tablero[0][2], true)
        }

        // Comprobación de casillas vacías

        val hayVacias = tablero.any { fila -> fila.any { it == TipoFicha.VACIO } }
        if (!hayVacias) {
            return Pair(TipoFicha.VACIO, true)
        }
        return Pair(TipoFicha.VACIO, false)

    }
}