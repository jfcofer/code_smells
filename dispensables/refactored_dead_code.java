public class CalculadoraAvanzada {

    public int sumar(int a, int b) {
        return a + b;
    }

    public int restar(int a, int b) {
        return a - b;
    }

    public double calcularRaizCuadrada(int a) {
        return Math.sqrt(a);
    }

    public double dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero");
        }
        return a / (double) b;
    }
}
