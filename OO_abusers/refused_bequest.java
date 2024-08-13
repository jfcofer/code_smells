public class refused_bequest{
    // Base class
    public class AnimalLegs {
        // Method that is appropriate for animals
        public void run() {
            System.out.println("Running with animal legs!");
        }

        // Method that is not appropriate for non-animal legs (e.g., chairs)
        public void walk() {
            System.out.println("Walking with animal legs!");
        }
    }

    // Subclass for dogs
    public class DogLegs extends AnimalLegs {
        // Dog-specific behavior
        public void fetch() {
            System.out.println("Fetching with dog legs!");
        }

        @Override
        public void run() {
            System.out.println("Running with dog legs!");
        }
    }

    // Subclass for chairs
    public class ChairLegs extends AnimalLegs {
        // Chair-specific behavior
        public void support() {
            System.out.println("Supporting with chair legs!");
        }

        // ChairLegs does not use `run()` or `walk()`
        @Override
        public void walk() {
            // This method is inappropriate for ChairLegs, but inherited
            // This is where we see the Refused Bequest smell
            System.out.println("This is not applicable for chair legs!");
        }
    }

    // Test class
    public class TestLegs {
        public static void main(String[] args) {
            AnimalLegs dogLegs = new DogLegs();
            dogLegs.run(); // Outputs: Running with dog legs!
            dogLegs.walk(); // Outputs: Walking with animal legs!

            AnimalLegs chairLegs = new ChairLegs();
            chairLegs.walk(); // Outputs: This is not applicable for chair legs!
        }
    }

}