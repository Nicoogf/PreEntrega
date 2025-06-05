package models;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<LineaPedido> lineaDePedido;
    private boolean confirmado;

    public Pedido() {
        this.lineaDePedido = new ArrayList<>();
        this.confirmado = false;
    }

    public void agregarProducto(Producto productoAgregado, int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        if (cantidad > productoAgregado.getStock()) {
            throw new IllegalArgumentException("No hay suficiente stock");
        }

        for (LineaPedido lp : lineaDePedido) {
            if (lp.getProducto().getId() == productoAgregado.getId()) {
                int nuevaCantidad = lp.getCantidad() + cantidad;
                if (nuevaCantidad > productoAgregado.getStock()) {
                    throw new IllegalArgumentException("No hay stock suficiente");
                }
                lineaDePedido.remove(lp);
                lineaDePedido.add(new LineaPedido(productoAgregado, nuevaCantidad));
                return;
            }
        }

        lineaDePedido.add(new LineaPedido(productoAgregado, cantidad));
    }

    public double calcularCostoTotal() {
        double total = 0;
        for (LineaPedido lp : lineaDePedido) {
            total += lp.getSubtotal();
        }
        return total;
    }

    public void confirmarPedido() {
        setConfirmado(true); // Uso del setter en lugar de acceder directamente
    }

    public void mostrarDetalles() {
        System.out.println("📄 Detalles del Pedido:");
        System.out.printf("%-20s %-12s %-10s %-10s%n", "Producto", "Precio", "Cantidad", "Subtotal");
        System.out.println("----------------------------------------------------------");

        for (LineaPedido lp : lineaDePedido) {
            Producto prod = lp.getProducto();
            System.out.printf("%-20s $%-11.2f %-10d $%-10.2f%n",
                    prod.getNombre(), prod.getPrecio(), lp.getCantidad(), lp.getSubtotal());
        }

        System.out.println("----------------------------------------------------------");
        System.out.printf("💰 Total del pedido: $%.2f%n", calcularCostoTotal());
    }

    public boolean estaVacio() {
        return lineaDePedido.isEmpty();
    }

    // ✅ Getters y Setters
    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public List<LineaPedido> getLineaDePedido() {
        return lineaDePedido;
    }
}
