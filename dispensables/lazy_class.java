public class Logger {

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class UserService {

    private Logger logger;

    public UserService() {
        this.logger = new Logger();
    }

    public void crearUsuario(String nombre) {
        System.out.println("Usuario " + nombre + " creado.");
        logger.log("Usuario " + nombre + " fue creado.");
    }

    public void eliminarUsuario(String nombre) {
        System.out.println("Usuario " + nombre + " eliminado.");
        logger.log("Usuario " + nombre + " fue eliminado.");
    }
}
