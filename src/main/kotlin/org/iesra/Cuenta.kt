package org.iesra

class Cuenta(val numCuenta: Int,var saldoDisponible : Double) {
    fun consultarSaldo(saldoDisponible : Double) {
        println("Saldo disponible: $saldoDisponible")
    }

    fun recibirAbonos(cantidad : Double) {
        saldoDisponible += cantidad
    }

    fun realizarPago(cantidad : Double) {
        saldoDisponible -= cantidad
    }

}