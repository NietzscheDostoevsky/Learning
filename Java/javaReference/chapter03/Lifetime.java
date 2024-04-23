class Lifetime {
    public static void main(String[] args) {
        // Demostrating lifetime of a variable using for loop

        int x;

        for (x = 0; x < 3; x++) {
            int y = -1; // This y will be iniatilized each time this block is entered, ie for each for
                        // interation
            System.out.println("y is : " + y);
            y = 100;
            System.out.println("y is now : " + y);

            // Y will alwyas reilitialize to -1 each time for loop runs
        }
    }
}
