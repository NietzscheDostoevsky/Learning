
// Demonstrating dynamic initilization 

/* The key point here is that the initialization expression may use any element valid at the time of the initialization,
including calls to methods, other variables, or literals. */
class DynInit {
    public static void main(String[] args) {
        double a = 3.0, b = 4.0;

        /*
         * Java allows variables to be initialized dynamically,
         * using any expression valid at the time the variable is declared
         */

        // variable c is dynamically initializad

        double c = Math.sqrt(a * a + b * b);

        System.out.println("Hypotenous is " + c);

    }
}