class FindNumber2 {
	public static void main(String[] args) {
		
		int number = 1334533533;
		int findnumber = 33;

		System.out.println(count(findnumber, number));
	}	

	public static int count(int findnumber, int number){

		if(number<=99){
			if(number == findnumber){
				return 1;
			} else {
				return 0;
			}
		} else {
			if(number % 100 == findnumber){
				return 1 + count(findnumber, number=number/10);
			} else {
				return 0 + count(findnumber, number=number/10);
			}
		}
	}
}