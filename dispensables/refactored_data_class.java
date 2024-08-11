public class Producto {

    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double calcularValorTotal() {
        return precio * cantidad;
    }

    public void aumentarCantidad(int cantidadAdicional) {
        if (cantidadAdicional > 0) {
            this.cantidad += cantidadAdicional;
        } else {
            throw new IllegalArgumentException("La cantidad adicional debe ser positiva");
        }
    }

    public void reducirCantidad(int cantidadReducida) {
        if (cantidadReducida > 0 && cantidadReducida <= cantidad) {
            this.cantidad -= cantidadReducida;
        } else {
            throw new IllegalArgumentException("La cantidad reducida debe ser positiva y no mayor a la cantidad actual");
        }
    }

    public void actualizarPrecio(double nuevoPrecio) {
        if (nuevoPrecio > 0) {
            this.precio = nuevoPrecio;
        } else {
            throw new IllegalArgumentException("El nuevo precio debe ser positivo");
        }
    }
}
