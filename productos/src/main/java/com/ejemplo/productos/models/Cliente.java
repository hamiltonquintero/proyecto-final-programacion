package com.ejemplo.productos.models;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String email;
    private String contrasena;
    private String direccion;
    private String telefono;
    private double saldoCuenta;

    private CarritoDeCompras carritoActivo;
    private List<Pedido> historialPedidos;

    // Constructor
    public Cliente(String nombre, String email, String contrasena, String direccion, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.telefono = telefono;
        this.saldoCuenta = 0.0;
        this.historialPedidos = new ArrayList<>();
    }

    // Método para actualizar datos
    public void actualizarDatos() {
        System.out.println("CLIENTE: Actualizando datos detallados de: " + nombre);
    }

    // Método para agregar pedidos al historial
    public void agregarPedido(Pedido pedido) {
        if (pedido != null) {
            historialPedidos.add(pedido);
        }
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public double getSaldoCuenta() { return saldoCuenta; }
    public void setSaldoCuenta(double saldoCuenta) { this.saldoCuenta = saldoCuenta; }

    public CarritoDeCompras getCarritoActivo() { return carritoActivo; }
    public void setCarritoActivo(CarritoDeCompras carritoActivo) { this.carritoActivo = carritoActivo; }

    public List<Pedido> getHistorialPedidos() { return historialPedidos; }
}