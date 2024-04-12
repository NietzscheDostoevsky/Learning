class ForTest{
    public static void main(String[] args) {

        int x;
        for (x=0; x<10; x = x + 1) // Use increment operator i++
            System.out.println("This is x : " + x) ;

        System.out.println("This is the update x : "  + x);
    }
}


// in Java, the x is updated and then the condition fails. 