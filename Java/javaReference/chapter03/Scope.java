class Scope {
    public static void main(String[] args) {

        int x; // known to all code withing main
        x = 10;

        if (x == 10) { // starting new scope
            int y = 20; // known only to this if block

            // x and y are both known here

            System.out.println("x and y: " + x + " " + y);
            x = y * 2;
        } // end if block

        // y = 100; // this should give error, as y is not defines error.

        // but x should still be known here .
        System.out.println("the val of x is " + x);
    }
}