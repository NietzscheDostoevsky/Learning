// Get the HCF and LCM of 2 numbers using Recursion

class HCFLCM {
	public static void main(String[] args) {
		int num1 = 12; 
		int num2 = 18;
		System.out.println("Num1 and Num2: \n" + num1 + " " + num2);
		System.out.println("LCM: " + lcm(num1, num2));
		System.out.println("HCF: " +hcf(num1, num2));
	}
	public static int hcf(int num1, int num2){
		if(num2 == 0){
			return num1;
		} else {
			return hcf(num2, num1%num2);
		}

	}

	public static int lcm(int num1, int num2){

		int hcfVal = hcf(num1, num2); 
		return (num1/hcfVal)*num2;
	}


}
