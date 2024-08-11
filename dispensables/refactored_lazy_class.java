public class UserService {

    public void crearUsuario(String nombre) {
        // Lógica para crear un usuario
        System.out.println("Usuario " + nombre + " creado.");

        // Registrar la operación
        log("Usuario " + nombre + " fue creado.");
    }

    public void eliminarUsuario(String nombre) {
        // Lógica para eliminar un usuario
        System.out.println("Usuario " + nombre + " eliminado.");

        // Registrar la operación
        log("Usuario " + nombre + " fue eliminado.");
    }

    private void log(String message) {
        System.out.println("LOG: " + message);
    }
}
