package com.ejemplo.productos.models;

import java.util.Date;

// Clase abstracta para todos los usuarios del sistema (Cliente, Administrador)
public abstract class Usuario {
    protected String nombre;
    protected String email;
    protected String contrasena;
    protected Date fechaRegistro;
    protected boolean estadoLogin;

    // Constructor vacío (necesario para Spring y JSON)
    public Usuario() {
        this.fechaRegistro = new Date();
        this.estadoLogin = false;
    }

    // Constructor con parámetros
    public Usuario(String nombre, String email, String contrasena) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.fechaRegistro = new Date();
        this.estadoLogin = false;
    }

    // Verifica la contraseña y el estado de sesión
    public boolean iniciarSesion(String contrasena) {
        if (this.contrasena.equals(contrasena)) {
            this.estadoLogin = true;
            System.out.println(nombre + " ha iniciado sesión.");
            return true;
        }
        System.out.println("Fallo de inicio de sesión para " + nombre);
        return false;
    }

    // Cierra sesión
    public void cerrarSesion() {
        this.estadoLogin = false;
        System.out.println(nombre + " ha cerrado sesión.");
    }

    // Método abstracto que obliga a las subclases a implementar su propia lógica de actualización
    public abstract void actualizarDatos();

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public Date getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Date fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public boolean isEstadoLogin() { return estadoLogin; }
    public void setEstadoLogin(boolean estadoLogin) { this.estadoLogin = estadoLogin; }
}