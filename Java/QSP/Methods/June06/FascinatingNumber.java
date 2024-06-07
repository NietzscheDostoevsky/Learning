class FascinatingNumber{

	public static int length(int num){

		int length = 0 ; 

		while(num!=0){

			length++ ;  
			num = num / 10  ; 
		}

		return length ; 
	}

	public static boolean isFascinating(int num){
		int numcopy = num ; 
		boolean flag = true ; 
		if(length(num)<3)
			return false ; 

		int numx2 = num * 2 ; 
		int numx3 = num * 3 ; 
		System.out.println(numcopy);
		System.out.println(numx2);
		System.out.println(numx3);

		int count0 = 0 ; 
		int count1 = 0 ; 
		int count2 = 0 ; 
		int count3 = 0 ; 
		int count4 = 0 ; 
		int count5 = 0 ; 
		int count6 = 0 ; 
		int count7 = 0 ; 
		int count8 = 0 ; 
		int count9 = 0 ; 

		int i = numx2 ; 
		while(i!=0){
			int digit = i%10 ; 
			if(digit == 0) count0++;
			if(digit == 1) count1++;
			if(digit == 2) count2++;
			if(digit == 3) count3++;
			if(digit == 4) count4++;
			if(digit == 5) count5++;
			if(digit == 6) count6++;
			if(digit == 7) count7++;
			if(digit == 8) count8++;
			if(digit == 9) count9++;

			i/=10 ;
		}

		i = numx3 ; 
		while(i!=0){
			int digit = i%10 ; 
			if(digit == 0) count0++;
			if(digit == 1) count1++;
			if(digit == 2) count2++;
			if(digit == 3) count3++;
			if(digit == 4) count4++;
			if(digit == 5) count5++;
			if(digit == 6) count6++;
			if(digit == 7) count7++;
			if(digit == 8) count8++;
			if(digit == 9) count9++;

			i/=10 ;
		}
		i = numcopy ; 
		while(i!=0){
			int digit = i%10 ; 
			if(digit == 0) count0++;
			if(digit == 1) count1++;
			if(digit == 2) count2++;
			if(digit == 3) count3++;
			if(digit == 4) count4++;
			if(digit == 5) count5++;
			if(digit == 6) count6++;
			if(digit == 7) count7++;
			if(digit == 8) count8++;
			if(digit == 9) count9++;

			i/=10 ;
		}

		flag = 		(count1 == 1) &&
					(count2 == 1) &&
					(count3 == 1) &&
					(count4 == 1) &&
					(count5 == 1) &&
					(count6 == 1) &&
					(count7 == 1) &&
					(count8 == 1) &&
					(count9 == 1)  ; 

		return flag ; 
	}

	

	public static void main(String[] args) {
		int num = 192 ; 

		if(isFascinating(num))
			System.out.println(num + " is Fascinating");
		else
			System.out.println(num + " is not Fascinating");

	}


}