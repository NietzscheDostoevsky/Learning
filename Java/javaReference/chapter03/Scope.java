class Scope { 
    public static void main(String[] args) { 

        int x ; // known to all code withing main 
        x = 10 ; 

        if (x == 10) { // starting new scope 
            int y = 20 ; // known only to this if block 

        }
    }
}