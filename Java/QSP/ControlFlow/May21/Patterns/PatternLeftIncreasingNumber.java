import java.util.Scanner ; 
public class PatternLeftIncreasingNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ; 
        System.out.print("Enter the number of rows to print: ");
        int input = sc.nextInt() ; 
        int n = input;
        int num = 1;


        for (int i = 0; i < n; i++) {

            // printing columns:
            
            int p = num ; 
            for (int j = 0; j <= i; j++) {
                System.out.print(p + " ");
                p--;
                num++ ; 
            }
            num++; // this process has to be done because num inside the for loop is already incrasing the number of times that loop is running
                    // but the next loop has to run to one more than the previos row number, so number has to be updated for the next row, ie add one 
                    // for example, in third row, using num++, num would be increased only 3 times, but the next row has to go on for 4 times, hence num++ after ending for loop 

            // Moving cursor to next row
            System.out.println();
            

        }
    }

}
