
// Demonstrating dynamic initilization 
class DynInit {
    public static void main(String[] args) {
        double a = 3.0 , b = 4.0 ; 
        
        /*
         * Java allows variables to be initialized dynamically, 
         * using any expression valid at the time the variable is declared
         */
        
        // variable c is dynamically initializad 

        double c = Math.sqrt( a * a + b * b ) ; 

        System.out.println("Hypotenous is " + c ) ; 

    }
}