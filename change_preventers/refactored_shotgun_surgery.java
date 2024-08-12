import java.util.ArrayList;
import java.util.List;

public class refactored_shotgun_surgery {

    /*
     * En el diseño revisado, se ha abordado el problema de la "cirugía con escopeta"
     * al mejorar la separación de responsabilidades y la encapsulación. Ahora, añadir
     * nuevas funcionalidades o subclases es mucho más sencillo, ya que el `User` sigue
     * siendo una clase base simple, y las características adicionales, como permisos,
     * se introducen mediante clases extendidas como `PermissionedUser` y `PermissionedUserService`.
     * Esto limita los cambios a áreas específicas del código, reduciendo el riesgo de errores
     * y facilitando la incorporación de nuevos tipos de usuarios o roles sin necesidad de modificar
     * el código existente. La estructura modular permite que las modificaciones se realicen
     * de manera aislada y ordenada, haciendo el sistema más fácil de mantener y extender.
     */

    // Printable interface for printing details
    interface Printable {
        void printDetails();
    }

    // Abstract User class
    abstract class User implements Printable {
        private String name;
        private Role role;

        public User(String name, Role role) {
            this.name = name;
            this.role = role;
        }

        public String getName() {
            return name;
        }

        public Role getRole() {
            return role;
        }
    }

    // Concrete User types
    class RegularUser extends User {
        public RegularUser(String name, Role role) {
            super(name, role);
        }

        @Override
        public void printDetails() {
            System.out.println("Regular User: " + getName() + ", Role: " + getRole().getRoleName());
        }
    }

    class PermissionedUser extends User {
        private List<String> permissions;

        public PermissionedUser(String name, Role role, List<String> permissions) {
            super(name, role);
            this.permissions = permissions;
        }

        public List<String> getPermissions() {
            return permissions;
        }

        @Override
        public void printDetails() {
            System.out.println("Permissioned User: " + getName() + ", Role: " + getRole().getRoleName() + ", Permissions: " + permissions);
        }
    }

    // Abstract Role class
    abstract class Role {
        public abstract String getRoleName();
    }

    // Concrete Role types
    class AdminRole extends Role {
        @Override
        public String getRoleName() {
            return "Admin";
        }
    }

    class UserRole extends Role {
        @Override
        public String getRoleName() {
            return "User";
        }
    }

    // Class to manage users and roles
    class UserService {
        private List<User> users = new ArrayList<>();

        public void addUser(User user) {
            users.add(user);
        }

        public boolean isUserAdmin(User user) {
            return "Admin".equals(user.getRole().getRoleName());
        }

        public void printUserDetails() {
            for (User user : users) {
                user.printDetails();
            }
        }
    }

    // Main class to demonstrate the refactored design
    public class Main {
        public static void main(String[] args) {
            Role adminRole = new AdminRole();
            Role userRole = new UserRole();

            UserService userService = new UserService();

            User user1 = new PermissionedUser("Alice", adminRole, List.of("READ", "WRITE"));
            User user2 = new RegularUser("Bob", userRole);

            userService.addUser(user1);
            userService.addUser(user2);

            userService.printUserDetails();

            System.out.println("Alice is an admin: " + userService.isUserAdmin(user1));
            System.out.println("Bob is an admin: " + userService.isUserAdmin(user2));
        }
    }

}
