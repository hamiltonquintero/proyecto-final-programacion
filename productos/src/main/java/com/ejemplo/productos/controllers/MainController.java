package com.ejemplo.productos.controllers;

import com.ejemplo.productos.models.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private Inventario inventario = new Inventario();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();

    public MainController() {
        // Pre-cargar datos para la sustentación
        clientes.add(new Cliente("Cliente Demo", "demo@test.com", "123456", "Calle Falsa 123", "555-1234"));
        inventario.agregarProducto(new Producto("Producto Demo", 100.0, 10, "General"));
        inventario.agregarProducto(new Producto("Smartphone", 800.0, 5, "Tecnología"));
        inventario.agregarProducto(new Producto("Auriculares", 50.0, 20, "Accesorios"));
        inventario.agregarProducto(new Producto("Monitor 24p", 200.0, 8, "Tecnología"));
    }

    // Endpoint de prueba
    @GetMapping("/test")
    public String test() {
        return "✅ Proyecto funcionando correctamente!";
    }

    // Endpoint para registrar cliente
    @PostMapping("/clientes")
    public String registrarCliente(@RequestBody Cliente cliente) {
        clientes.add(cliente);
        return "Cliente registrado: " + cliente.getNombre();
    }

    // Endpoint para agregar producto
    @PostMapping("/productos")
    public String agregarProducto(@RequestBody Producto producto) {
        inventario.agregarProducto(producto);
        return "Producto agregado: " + producto.getNombre();
    }

    // Endpoint para listar productos
    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        return inventario.getProductos();
    }

    // ✅ Nuevo: Endpoint para registrar pedido
    @PostMapping("/pedidos")
    public String registrarPedido(@RequestBody Pedido pedido) {
        pedidos.add(pedido);
        return "Pedido registrado para cliente: " + pedido.getCliente().getNombre();
    }

    // ✅ Nuevo: Endpoint para listar pedidos
    @GetMapping("/pedidos")
    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    // ✅ Nuevo: Endpoint para eliminar producto
    @DeleteMapping("/productos/{nombre}")
    public String eliminarProducto(@PathVariable String nombre) {
        boolean eliminado = inventario.eliminarProducto(nombre);
        if (eliminado) {
            return "Producto eliminado correctamente: " + nombre;
        } else {
            return "Error: No se encontró el producto " + nombre;
        }
    }
}