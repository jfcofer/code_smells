import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private List<User> users = new ArrayList<>();
    private List<Role> roles = new ArrayList<>();

    // User Management Methods
    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    // Role Management Methods
    public void addRole(Role role) {
        roles.add(role);
    }

    public void removeRole(Role role) {
        roles.remove(role);
    }

    public Role findRoleByName(String roleName) {
        for (Role role : roles) {
            if (role.getName().equals(roleName)) {
                return role;
            }
        }
        return null;
    }

    public List<Role> getAllRoles() {
        return new ArrayList<>(roles);
    }

    // Authentication Methods
    public boolean authenticate(String username, String password) {
        User user = findUserByUsername(username);
        if (user != null) {
            return user.getPassword().equals(password);
        }
        return false;
    }

    public void changePassword(User user, String newPassword) {
        user.setPassword(newPassword);
    }

    // Permission Management Methods
    public void assignRoleToUser(User user, Role role) {
        user.addRole(role);
    }

    public void removeRoleFromUser(User user, Role role) {
        user.removeRole(role);
    }

    public boolean userHasRole(User user, String roleName) {
        for (Role role : user.getRoles()) {
            if (role.getName().equals(roleName)) {
                return true;
            }
        }
        return false;
    }
}

// Supporting Classes for Users and Roles
class User {
    private String username;
    private String password;
    private List<Role> roles;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.roles = new ArrayList<>();
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public List<Role> getRoles() { return roles; }
    public void addRole(Role role) { roles.add(role); }
    public void removeRole(Role role) { roles.remove(role); }
}

class Role {
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public String getName() { return name; }
}