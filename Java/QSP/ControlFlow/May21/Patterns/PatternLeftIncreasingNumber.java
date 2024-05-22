
public class PatternLeftIncreasingNumber {
    public static void main(String[] args) {
        int n = 5;
        int num = 0;


        for (int i = 0; i < n; i++) {

            // printing columns:
            num++;
            int p = num ; 
            for (int j = 0; j <= i; j++) {
                System.out.print(p + " ");
                p--;
                num++ ; 
            }


            // Moving cursor to next row
            System.out.println();
            

        }
    }

}
