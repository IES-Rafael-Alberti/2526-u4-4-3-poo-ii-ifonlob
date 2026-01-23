package org.iesra

class Cuenta(val numCuenta: Int, private var saldoDisponible : Double){

    companion object {
        fun esMorosa(persona: Persona) : Boolean {
            for(cuenta in persona.cuentas){
                if(cuenta != null && cuenta.saldoDisponible < 0){
                    return true
                }
            }
            return false
        }

        fun transferencia(persona1: Persona,persona2: Persona,indiceCuenta1: Int, indiceCuenta2 : Int, cantidad: Double) : Boolean {
            val cuentaOrigen = persona1.cuentas.getOrNull(indiceCuenta1)
            val cuentaDestino = persona2.cuentas.getOrNull(indiceCuenta2)

            if(cuentaDestino == null && cuentaOrigen == null || cantidad < 0){
                return false
            }
            else{
                if(cuentaOrigen != null && cuentaDestino != null){
                    cuentaOrigen.realizarPago(cantidad)
                    cuentaDestino.recibirAbonos(cantidad)
                }
            }
            return true
        }
    }

    fun consultarSaldo() : String{
        return "Saldo disponible: ${this.saldoDisponible}"
    }

    fun recibirAbonos(cantidad : Double) {
        saldoDisponible += cantidad
    }

    fun realizarPago(cantidad : Double) {
        saldoDisponible -= cantidad
    }

}