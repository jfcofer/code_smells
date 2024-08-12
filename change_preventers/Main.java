import java.util.ArrayList;
import java.util.List;

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

public class Main {
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
