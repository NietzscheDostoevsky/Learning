import java.util.Scanner;
public class EvenOdd {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in) ; 
        System.out.print("Enter the number : " ); 
        int num = sc.nextInt();
        
        System.out.println(num%2==0?"even":"odd"); 
        



    }
}
