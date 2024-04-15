class IfSimple{

    public static void main(String[] args) {
        int x, y;

        x = 10;
        y = 20;

        if (x < y) System.out.println("x is less tha y");
        x = x * 2 ; 
        if (x == y) System.out.println("x is not equal to y");

        x = x * 2 ;
        if (x > y) System.out.println("x is now grater than y");

        if (x==y) System.out.println("This line should not be printted") ;
        
    }

}