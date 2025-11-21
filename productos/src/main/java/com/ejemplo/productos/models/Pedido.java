package com.ejemplo.productos.models;

import java.util.Date;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<ItemCarrito> items;
    private Date fechaPedido;
    private String estado;
    private InformacionEnvio informacionEnvio;
    private double total;

    public Pedido() {}

    public Pedido(Cliente cliente, CarritoDeCompras carrito, String tipoEnvio) {
        this.cliente = cliente;
        this.items = carrito.getItems();
        this.fechaPedido = new Date();
        this.estado = "Pendiente";
        this.total = carrito.calcularTotal();
        this.informacionEnvio = new InformacionEnvio(tipoEnvio, cliente.getDireccion());
    }

    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("PEDIDO: El estado del pedido de " + cliente.getNombre() + " ha cambiado a: " + nuevoEstado);
    }

    public void generarFactura() {
        double subtotal = total;
        double costoEnvio = informacionEnvio.getCostoEnvio();
        double totalFinal = subtotal + costoEnvio;

        System.out.println("\n--- FACTURA ---");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.printf("Subtotal: $%.2f\n", subtotal);
        System.out.printf("Costo Envío: $%.2f\n", costoEnvio);
        System.out.printf("Total Final: $%.2f\n", totalFinal);
        System.out.println("Estado: " + estado);
        System.out.println("-----------------");
    }

    // Getters y Setters
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public List<ItemCarrito> getItems() { return items; }
    public void setItems(List<ItemCarrito> items) { this.items = items; }

    public Date getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(Date fechaPedido) { this.fechaPedido = fechaPedido; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public InformacionEnvio getInformacionEnvio() { return informacionEnvio; }
    public void setInformacionEnvio(InformacionEnvio informacionEnvio) { this.informacionEnvio = informacionEnvio; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}