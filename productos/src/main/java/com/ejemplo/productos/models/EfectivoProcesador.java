package com.ejemplo.productos.models;

// Implementación de pago en efectivo
public class EfectivoProcesador implements IProcesadorPago {

    @Override
    public boolean procesar(double monto) {
        System.out.println("LOG: Verificando monto en efectivo...");
        // El pago en efectivo se considera válido si el monto es mayor que cero
        return monto > 0;
    }
}