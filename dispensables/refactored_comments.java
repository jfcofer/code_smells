public class ProcesadorDePedidos {

    public void procesarPedido(Pedido pedido) {
        validarPedido(pedido);
        double total = calcularTotalConDescuento(pedido);
        actualizarInventario(pedido);
        Factura factura = generarFactura(pedido, total);
        enviarFacturaAlCliente(factura);
    }

    private void validarPedido(Pedido pedido) {
        if (!pedidoEsValido(pedido)) {
            throw new IllegalArgumentException("El pedido no es válido");
        }
    }

    private boolean pedidoEsValido(Pedido pedido) {
        return pedido.tieneArticulos() && !pedido.estaExpirado();
    }

    private double calcularTotalConDescuento(Pedido pedido) {
        double total = calcularTotalPedido(pedido);
        if (pedido.getCliente().esVip()) {
            total = aplicarDescuentoVip(total);
        }
        return total;
    }

    private double calcularTotalPedido(Pedido pedido) {
        return pedido.getArticulos().stream()
                     .mapToDouble(Articulo::getPrecio)
                     .sum();
    }

    private double aplicarDescuentoVip(double total) {
        return total * 0.9;
    }

    private void actualizarInventario(Pedido pedido) {
        pedido.getArticulos().forEach(articulo ->
            Inventario.reducirCantidad(articulo, articulo.getCantidad())
        );
    }

    private Factura generarFactura(Pedido pedido, double total) {
        return new Factura(pedido, total);
    }

    private void enviarFacturaAlCliente(Factura factura) {
        ServicioDeCorreo.enviar(factura);
    }
}

