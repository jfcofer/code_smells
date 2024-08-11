public class ProcesadorDePedidos {

    // Este método procesa un pedido dado
    public void procesarPedido(Pedido pedido) {
        // Verificar si el pedido es válido
        if (!esPedidoValido(pedido)) {
            throw new IllegalArgumentException("El pedido no es válido");
        }

        // Calcular el total del pedido
        double total = calcularTotalPedido(pedido);

        // Aplicar un descuento si el cliente es VIP
        if (pedido.getCliente().esVip()) {
            total = aplicarDescuentoVip(total);
        }

        // Actualizar el inventario con los artículos del pedido
        actualizarInventario(pedido);

        // Generar la factura
        Factura factura = generarFactura(pedido, total);

        // Enviar la factura al cliente
        enviarFactura(factura);
    }

    private boolean esPedidoValido(Pedido pedido) {
        // Comprobar que el pedido tenga artículos y que no haya expirado
        return pedido.tieneArticulos() && !pedido.estaExpirado();
    }

    private double calcularTotalPedido(Pedido pedido) {
        // Sumar el precio de todos los artículos del pedido
        double total = 0;
        for (Articulo articulo : pedido.getArticulos()) {
            total += articulo.getPrecio();
        }
        return total;
    }

    private double aplicarDescuentoVip(double total) {
        // Aplicar un descuento del 10% para clientes VIP
        return total * 0.9;
    }

    private void actualizarInventario(Pedido pedido) {
        // Restar la cantidad de artículos del inventario
        for (Articulo articulo : pedido.getArticulos()) {
            Inventario.reducirCantidad(articulo, articulo.getCantidad());
        }
    }

    private Factura generarFactura(Pedido pedido, double total) {
        // Crear una nueva factura con el pedido y el total calculado
        return new Factura(pedido, total);
    }

    private void enviarFactura(Factura factura) {
        // Enviar la factura al cliente por correo electrónico
        ServicioDeCorreo.enviar(factura);
    }
}
