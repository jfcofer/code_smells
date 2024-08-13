public class refactored_temporary_field {
    
    public class Authenticator {
        private String username;
        private String password;
    
        public Authenticator(String username, String password) {
            this.username = username;
            this.password = password;
        }
    
        public void authenticate() {
            // Example authentication logic (simplified for demonstration purposes)
            String message; // Local variable used
            if (username.equals("admin") && password.equals("password123")) {
                message = "Authentication successful!";
            } else {
                message = "Authentication failed.";
            }
            System.out.println(message);
        }
    }
    
}
