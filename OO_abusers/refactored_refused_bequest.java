public class refactored_refused_bequest {
        // Define a Legs interface
    public interface Legs {
        void support();
    }

    // Implement DogLegs
    public class DogLegs implements Legs {
        @Override
        public void support() {
            System.out.println("Supporting with dog legs!");
        }

        // Dog-specific behavior
        public void fetch() {
            System.out.println("Fetching with dog legs!");
        }
    }

    // Implement ChairLegs
    public class ChairLegs implements Legs {
        @Override
        public void support() {
            System.out.println("Supporting with chair legs!");
        }
    }

    // Define an Animal class that uses Legs via composition
    public class Animal {
        private Legs legs;

        // Constructor to inject the type of legs
        public Animal(Legs legs) {
            this.legs = legs;
        }

        public void support() {
            legs.support();
        }
    }

    // Define a Chair class that uses Legs via composition
    public class Chair {
        private Legs legs;

        // Constructor to inject the type of legs
        public Chair(Legs legs) {
            this.legs = legs;
        }

        public void support() {
            legs.support();
        }
    }

    // Test class
    public class TestComposition {
        public static void main(String[] args) {
            // Create instances of legs
            Legs dogLegs = new DogLegs();
            Legs chairLegs = new ChairLegs();

            // Create instances of Animal and Chair using composition
            Animal dog = new Animal(dogLegs);
            Chair officeChair = new Chair(chairLegs);

            // Demonstrate the use of composition
            dog.support(); // Outputs: Supporting with dog legs!
            ((DogLegs) dogLegs).fetch(); // Outputs: Fetching with dog legs!

            officeChair.support(); // Outputs: Supporting with chair legs!
        }
    }

}
