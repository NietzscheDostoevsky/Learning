import java.util.Scanner;

public class HollowPatterns {

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the number to rows: ");
        // int input = sc.nextInt();
        // int n = input ;
        int n = 4;

        //hollowTriangle(n); 
       // hollowSquareDiagonals(n);
        abcdSquare(n);

    }


    public static void hollowTriangle(int n) {

        // printing a left side triangle with hollow body
        //outer loop for rows 
        for(int i = 0; i<n; i++) {
            // inner loop 
            for(int j=1; j<=i+1; j++){
                if(i==(j-1)||(j==1)||(i==(n-1))){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println(); 
        }
   }     
    public static void hollowSquareDiagonals(int n) {

        // outer loop for rows 
        for(int i = 0; i<n ; i++){

            // inner star print 
            for(int j = 0; j<n; j++){
                if((i==0)||(i==(n-1))||(j==0)||(j==(n-1))){
                    System.out.print("*");
                }

            }System.out.println();
                

        }


    }
    public static void abcdSquare(int n) {
        char alpha = 'a';
        int num = 8 ; 

        for(int i = 0 ; i<n; i++){
            for(int j = 0; i<n; j++){
                if(i%2==1){
                    System.out.print(alpha);
                    alpha++;
                }
                else if(i%2==0){
                    System.out.print(num);
                    num--;
                }
            }
            System.out.println();
        }

    }

}
