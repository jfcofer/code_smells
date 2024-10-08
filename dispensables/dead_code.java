public class CalculadoraAvanzada {

    private double resultadoAnterior; // Esta variable nunca se usa

    public int sumar(int a, int b) {
        return a + b;
    }

    public int restar(int a, int b) {
        return a - b;
    }

    public double calcularRaizCuadrada(int a) {
        return Math.sqrt(a);
    }

    // Método no utilizado en ningún lugar del código
    public void imprimirResultado(int resultado) {
        System.out.println("El resultado es: " + resultado);
    }

    // Método que no se utiliza en el código
    public void resetearResultado() {
        resultadoAnterior = 0;
    }

    public double dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero");
        }
        return a / (double) b;
    }
}
