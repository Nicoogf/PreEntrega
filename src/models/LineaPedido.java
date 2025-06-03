package models;

public class LineaPedido {
    private Producto producto ;
    private int cantidad ;

    public LineaPedido ( Producto producto , int cantidad ){
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }
        if (cantidad > producto.getStock()) {
            throw new IllegalArgumentException("No hay stock suficiente para el producto: " + producto.getNombre());
        }
        this.producto =  producto ;
        this.cantidad = cantidad ;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getSubtotal() {
        return producto.getPrecio() * cantidad ;
    }
}
