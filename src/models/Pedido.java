package models;


import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<LineaPedido> lineaDePedido ;

    public Pedido(){
        this.lineaDePedido = new ArrayList<>() ;
    }

    public void agregarProducto( Producto productoAgregado , int cantidad ) {
        if( cantidad < 0 ) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa") ;
        }
        if( cantidad > productoAgregado.getStock() ) {
            throw new IllegalArgumentException("No hay suficiente stock") ;
        }
        for(LineaPedido lp : lineaDePedido ) {
            if(lp.getProducto().getId() == productoAgregado.getId()){
                int nuevaCantidad =  lp.getCantidad() + cantidad ;
                if( nuevaCantidad > productoAgregado.getStock() ){
                    throw new IllegalArgumentException("No hay Stock suficiente") ;
                }
                lineaDePedido.remove(lp);
                lineaDePedido.add( new LineaPedido(productoAgregado ,nuevaCantidad )) ;
                return ;
            }
        }
        lineaDePedido.add(new LineaPedido(productoAgregado, cantidad));
    }

    public double calcularCostoTotal() {
        double total = 0 ;
        for (LineaPedido lp : lineaDePedido) {
            total +=   lp.getSubtotal();
        }
        return total;
    }





}
