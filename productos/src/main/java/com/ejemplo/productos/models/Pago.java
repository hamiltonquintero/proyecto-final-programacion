package com.ejemplo.productos.models;

import java.util.Date;

public class Pago {
    private Pedido pedido; 
    private IProcesadorPago procesador; 
    private String metodoPago; 
    private Date fechaPago;
    private double monto;

    // Constructor vacío (necesario para Spring y JSON)
    public Pago() {}

    // Constructor con parámetros
    public Pago(Pedido pedido, IProcesadorPago procesador, String metodoPago) {
        this.pedido = pedido;
        this.metodoPago = metodoPago;
        this.procesador = procesador;
        this.monto = pedido.getTotal() + pedido.getInformacionEnvio().getCostoEnvio();
    }

    // Procesar el pago
    public boolean procesarPago() {
        System.out.printf("Iniciando pago de $%.2f con %s...\n", monto, metodoPago);

        if (procesador.procesar(monto)) {
            this.fechaPago = new Date();
            pedido.actualizarEstado("Pagado");
            System.out.println("Pago exitoso. Fecha: " + fechaPago);
            return true;
        } else {
            pedido.actualizarEstado("Fallo de Pago");
            System.out.println("ERROR: El pago con " + metodoPago + " ha fallado.");
            return false;
        }
    }

    // Emitir recibo
    public void emitirRecibo() {
        System.out.println("Recibo emitido para el pedido " + pedido.getCliente().getNombre());
    }

    // Getters y Setters
    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }

    public IProcesadorPago getProcesador() { return procesador; }
    public void setProcesador(IProcesadorPago procesador) { this.procesador = procesador; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public Date getFechaPago() { return fechaPago; }
    public void setFechaPago(Date fechaPago) { this.fechaPago = fechaPago; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
}