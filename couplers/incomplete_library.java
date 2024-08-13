import java.util.ArrayList;
import java.util.List;

public class CustomList<E> extends ArrayList<E> {

    public CustomList() {
        super();
    }

    // Método existente para agregar un elemento
    @Override
    public boolean add(E element) {
        return super.add(element);
    }

    // Método personalizado para agregar una colección de elementos uno por uno
    public void addAllElements(List<E> elements) {
        for (E element : elements) {
            this.add(element);
        }
    }

    // Incomplete Library Class: Faltan métodos útiles como eliminar una colección de elementos
    // o verificar si la lista contiene todos los elementos de otra lista, etc.
}

public class Main {
    public static void main(String[] args) {
        CustomList<String> customList = new CustomList<>();
        customList.add("Apple");
        customList.add("Banana");

        List<String> fruits = List.of("Orange", "Grapes", "Banana");

        customList.addAllElements(fruits);

        System.out.println("Custom List: " + customList);

        // Intentar eliminar múltiples elementos requeriría una implementación personalizada
        // Esto es un ejemplo donde la clase podría considerarse incompleta
        // por no tener tales métodos de utilidad.
    }
}
