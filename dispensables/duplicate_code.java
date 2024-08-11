public class PedidoService {

    public double calcularTotalPedido(Pedido pedido) {
        double total = 0;
        for (Articulo articulo : pedido.getArticulos()) {
            total += articulo.getPrecio() * articulo.getCantidad();
        }

        // Aplicar descuento si es un cliente VIP
        if (pedido.getCliente().esVip()) {
            total = total * 0.9; // 10% de descuento
        }

        return total;
    }

    public void procesarPedido(Pedido pedido) {
        double total = 0;
        for (Articulo articulo : pedido.getArticulos()) {
            total += articulo.getPrecio() * articulo.getCantidad();
        }

        // Aplicar descuento si es un cliente VIP
        if (pedido.getCliente().esVip()) {
            total = total * 0.9; // 10% de descuento
        }

        // Generar factura
        Factura factura = new Factura(pedido, total);
        // Lógica para guardar la factura o enviarla al cliente...
    }
}
