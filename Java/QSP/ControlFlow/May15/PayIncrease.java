import java.util.Scanner;

class PayIncrease{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in) ; 
        System.out.print("Enter salary: ");

        double salary = sc.nextInt();

        System.out.print("Enter target : ");
        int target = sc.nextInt();

        if(target > 90){
            salary = salary * 1.03; 
        }else{
            salary = salary * 1.01; 
        }
        System.out.println("Salary = " + salary);


    }
}