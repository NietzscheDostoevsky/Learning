import java.util.Scanner; 

public class VovelOrConsonant {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter a character : ");
        char ch = sc.next().toLowerCase().charAt(0); 
        boolean logic = (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') ; 

       System.out.println(logic?ch + "is Vovel":ch + " is consonant") ; 

        
    }
    
}
