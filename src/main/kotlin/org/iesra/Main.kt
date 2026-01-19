package org.iesra

fun main() {
    /* EJERCICIO 2 */
    val persona1 = Persona("12345678P")
    val cuenta1 = Cuenta(556456,0.0)
    val cuenta2 = Cuenta(817003,700.0)

    persona1.añadirCuenta(cuenta1)
    persona1.añadirCuenta(cuenta2)

    cuenta1.recibirAbonos(1100.0)
    cuenta2.realizarPago(750.0)
    val esMorosa = Cuenta.esMorosa(persona1)
    println(if (esMorosa) "Es morosa" else "No es morosa")

    Cuenta.transferencia(persona1,persona1,0,1, 400.0)

    println("Saldo cuenta1: ${cuenta1.consultarSaldo()}")
    println("Saldo cuenta2: ${cuenta2.consultarSaldo()}")
}
