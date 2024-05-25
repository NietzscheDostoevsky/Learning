class CaseQuestion{
	public static void main(String[] args){

		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("Enter a number : ");
		int input = sc.nextInt(); 

		boolean isDivBy3 = false ;
		boolean isDivBy5 = false ; 
		
		if(input%3 == 0)
			isDivBy3 = true ;
		if(input%5 == 0)
			isDivBy5 = true ;

		if(isDivBy3 && isDivBy5)
			System.out.println("Hiii Byee");
		else if(isDivBy3)
			System.out.println("Hiiiii");
		else if(isDivBy5)
			System.out.println("Byee");
		else
			System.out.println(input);
	}
}