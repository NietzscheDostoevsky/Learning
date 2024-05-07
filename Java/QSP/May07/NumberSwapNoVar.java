public class NumberSwapNoVar {
    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        
       a = a + b ; // a = 12
       b = a - b ; // b = 5 
       a = a - b ; 

       System.out.println(a);
       System.out.println(b);

    }
}
