package models;

public class Producto {
    static int contadorProductos = 0 ;
    private String nombre ;
    private double precio ;
    private int id ;
    private int stock ;

    public Producto (String nombre , double precio , int stock) {
        if(  nombre == null  ||nombre.isBlank() ){
            throw new IllegalArgumentException("El campo nombre no puede ser nulo o vacio") ;
        }
        if( stock < 0 || precio < 0 ){
            throw new IllegalArgumentException("El precio y el Stock no pueden ser negativos") ;
        }
        this.nombre = nombre ;
        this.precio = precio ;
        this.stock = stock ;
        this.id = contadorProductos ;
        contadorProductos++ ;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre == null ||  nombre.isBlank()) {
            throw new IllegalArgumentException("El campo nombre no puede ser nulo o vacio") ;
        }
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if( precio < 0 ){
            throw new IllegalArgumentException("El precio no puede ser negativo") ;
        }
        this.precio = precio;
    }

    public int getId() {
        return id;
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if( stock < 0 ){
            throw new IllegalArgumentException("El stock no puede ser negativo") ;
        }
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", id=" + id +
                ", stock=" + stock +
                '}';
    }
}
