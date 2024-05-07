import java.util.Scanner; 

public class ReverseNumberLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a 3 digit number : ");

        int num = sc.nextInt();
        int rev = 0 ; 
       for(int i =num;i!=0;i/=10)
                rev=rev*10+(i%10);
        System.out.println(num + " Number's reverse value is  " + rev);
    }
    
}
