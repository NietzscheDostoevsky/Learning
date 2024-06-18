// To find a num in the digit and get the count 
// of the found digit usign method recursion. 

import java.util.Scanner ;
class NumberInDigit {
		public static void main(String[] args) {

			Scanner sc = new Scanner(System.in); 
			//System.out.println("Enter the number: ");
			//int num = sc.nextInt();
			int number = 33433635;
			int findnumber = 33;
			//int count = 0  ;
			System.out.println(count(findnumber, number));
			
		}

		public static int count( int findnumber, int number){
			if(number<=99){
				if(number==findnumber){
					return 1;
				} else {
					return 0; 
				}
			} else {
				if(number%100 == findnumber){
					return 1 + count(findnumber, number=number/10);
				} else {
					return 0 + count(findnumber, number=number/10);
				}
			}
		}

}

