public class PedidoService {

    public double calcularTotalPedido(Pedido pedido) {
        double total = calcularSubtotal(pedido);

        if (pedido.getCliente().esVip()) {
            total = aplicarDescuentoVip(total);
        }

        return total;
    }

    public void procesarPedido(Pedido pedido) {
        double total = calcularTotalPedido(pedido);

        // Generar factura
        Factura factura = new Factura(pedido, total);
        // Lógica para guardar la factura o enviarla al cliente...
    }

    private double calcularSubtotal(Pedido pedido) {
        return pedido.getArticulos().stream()
                     .mapToDouble(articulo -> articulo.getPrecio() * articulo.getCantidad())
                     .sum();
    }

    private double aplicarDescuentoVip(double total) {
        return total * 0.9; // 10% de descuento
    }
}
