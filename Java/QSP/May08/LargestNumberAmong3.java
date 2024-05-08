import java.util.Scanner;

class LargestNumberAmong3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter num1 : ");
        int num1 = sc.nextInt();
        System.out.print("Enter num2 : ");
        int num2 = sc.nextInt();
        System.out.print("Enter num3 : ");
        int num3 = sc.nextInt();

        boolean logic1 = num1 > num2;
        boolean logic2 = num1 > num3;
        boolean logic3 = num2 > num3;

        int largest = logic1 ? (logic2 ? num1 : num3) : (logic3 ? num2 : num3);
        String str = String.format("The largest value among %d, %d, %d is : %d", num1, num2, num3, largest);
        System.out.println(str);
    }

}