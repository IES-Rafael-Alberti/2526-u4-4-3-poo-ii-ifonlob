package org.iesra

class Persona(val dni: String) {
    val cuentas : Array<Cuenta?> = arrayOfNulls(3)
    var numCuentas: Int = 0

    fun añadirCuenta(cuenta: Cuenta) : Boolean {
        if (numCuentas >= cuentas.size){
            return false
        }
        else{
            cuentas[numCuentas] = cuenta
            numCuentas++
            return true
        }
    }
}