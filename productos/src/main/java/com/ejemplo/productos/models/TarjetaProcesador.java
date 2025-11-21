package com.ejemplo.productos.models;

// Implementación de pago con tarjeta
public class TarjetaProcesador implements IProcesadorPago {

    @Override
    public boolean procesar(double monto) {
        System.out.println("LOG: Contactando pasarela de pago y verificando tarjeta...");
        // Simulación: 90% de probabilidad de éxito
        return Math.random() < 0.9 && monto > 0;
    }
}