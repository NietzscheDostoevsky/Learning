import java.util.Scanner; 

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a 3 digit number : ");

        int num = sc.nextInt();
        int dup = num ; 
        int rev = 0 ; 

        int rem = num % 10 ; 
        rev = (rev*10) + rem ; 
        num = num / 10 ; 
        rem = num % 10 ; 
        rev = (rev*10) + rem ; 
        num = num / 10 ; 
        rem = num%10; 
        rev = rev*10 + rem ; 
        System.out.println(dup + " Number's reverse value is  " + rev);
    }
    
}
