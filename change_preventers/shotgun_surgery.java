import java.util.ArrayList;
import java.util.List;

class shotgun_surgery{

    /*
    Explicación del Problema de "Shotgun Surgery"
    En el diseño original, añadir nuevos tipos de usuarios, roles o mecanismos de impresión 
    implicaba modificaciones extensas en varias clases. Por ejemplo, si quisiéramos agregar
    un nuevo tipo de usuario o rol, tendríamos que cambiar las clases de usuario y rol 
    existentes y posiblemente actualizar la funcionalidad de impresión esparcida por el código.
    Este enfoque fragmentado se conoce como "shotgun surgery" (cirugía con escopeta), 
    donde un solo cambio requiere actualizaciones en numerosos lugares, aumentando el riesgo
    de errores y haciendo que el sistema sea más difícil de mantener. Cada nueva funcionalidad
    o ajuste requiere consideraciones cuidadosas y modificaciones en múltiples áreas, lo que 
    lleva a un código base frágil y complejo.
     */

    // User class
    class User {
        private String name;
        private String role;

        public User(String name, String role) {
            this.name = name;
            this.role = role;
        }

        public String getName() {
            return name;
        }

        public String getRole() {
            return role;
        }
    }

    // UserService class
    class UserService {
        private List<User> users = new ArrayList<>();

        public void addUser(User user) {
            users.add(user);
        }

        public boolean isUserAdmin(User user) {
            return "Admin".equals(user.getRole());
        }

        public void printUserDetails(User user) {
            System.out.println("User: " + user.getName() + ", Role: " + user.getRole());
        }
    }

    // UserPrinter class
    class UserPrinter {
        public void printUser(User user) {
            System.out.println("User: " + user.getName() + ", Role: " + user.getRole());
        }
    }

    // Adding a new feature: User permissions
    // This change requires updates to various classes

    class PermissionedUser extends User {
        private List<String> permissions;

        public PermissionedUser(String name, String role, List<String> permissions) {
            super(name, role);
            this.permissions = permissions;
        }

        public List<String> getPermissions() {
            return permissions;
        }
    }

    class PermissionedUserService extends UserService {
        public boolean hasPermission(User user, String permission) {
            if (user instanceof PermissionedUser) {
                return ((PermissionedUser) user).getPermissions().contains(permission);
            }
            return false;
        }

        @Override
        public void printUserDetails(User user) {
            if (user instanceof PermissionedUser) {
                System.out.println("User: " + user.getName() + ", Role: " + user.getRole() + ", Permissions: " + ((PermissionedUser) user).getPermissions());
            } else {
                super.printUserDetails(user);
            }
        }
    }


    public static void main(String[] args) {
        UserService userService = new PermissionedUserService();
        User user1 = new PermissionedUser("Alice", "Admin", List.of("READ", "WRITE"));
        User user2 = new User("Bob", "User");

        userService.addUser(user1);
        userService.addUser(user2);

        userService.printUserDetails(user1);
        userService.printUserDetails(user2);

        System.out.println("Alice has WRITE permission: " + ((PermissionedUserService) userService).hasPermission(user1, "WRITE"));
    }

}