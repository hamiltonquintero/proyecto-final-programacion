package com.ejemplo.productos.models;

// Interfaz para procesadores de pago
// Obliga a las clases concretas a implementar el método procesar
public interface IProcesadorPago {
    boolean procesar(double monto);
}