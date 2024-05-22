
public class PatternLeftIncreasingNumber {
    public static void main(String[] args) {
        int n = 5;
        int diff = 1;
        int num = 1; 
        for (int i = 0; i < n; i++) {

            // printing columns:
            

            for (int j = 0; j <= i; j++) {
                System.out.print(num);
                num--;
            }

            // Moving cursor to next row
            System.out.println();
            diff++;
            num = num + diff;

        }
    }

}
