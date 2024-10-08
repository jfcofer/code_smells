public class temporary_field{

    public class Authenticator {
        private String username;
        private String password;
        private String temporaryMessage; // Code smell: Temporary field

        public Authenticator(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public void authenticate() {
            // Example authentication logic (simplified for demonstration purposes)
            if (username.equals("admin") && password.equals("password123")) {
                temporaryMessage = "Authentication successful!"; // Temporary field used
            } else {
                temporaryMessage = "Authentication failed."; // Temporary field used
            }
            System.out.println(temporaryMessage);
        }
    }

}
