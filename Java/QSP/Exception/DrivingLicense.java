import java.util.Scanner;

public class DrivingLicense {  // Fixed class declaration
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your age: ");
        int age = sc.nextInt(); 

        if (!(age < 18)) {
            System.out.println("Your age is eligible");  // Fixed typo
            System.out.println("Enter your score:");  // Fixed typo
            double score = sc.nextDouble(); 
            if (score < 60) {
                throw new LessScoreException("You have failed by " + (60 - score) + " marks");
            } else {
                System.out.println("You are eligible for a Driving License");  // Fixed typo
            }            
        } else {
            throw new UnderAgeException("You are underage, try after " + (18 - age) + " years");
        }
    }
}

class LessScoreException extends RuntimeException {
    LessScoreException(String desc) {
        super(desc); 
    }
}

class UnderAgeException extends RuntimeException {
    UnderAgeException(String desc) {
        super(desc);
    }
}
