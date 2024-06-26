import java.util.*;
class PrimeArray {

	static int num = 2;
	public static void main(String[] args) {
		
		int[] arr = new int[10];
		int indx = 0;
		int count = 0;
		for(;;) {
			if(fethchPrimeNumber()){
				arr[indx++] = num;
				count++;
			}
			num++;
			if(count==10) {
				break;
			}
		}
		System.out.println(Arrays.toString(arr));

	}

	public static boolean fethchPrimeNumber(){
		boolean flag = true;

		for(int i = 2; i<num; i++){
			if(num%i == 0){
				flag= false;
				break;
			}
		}
		return flag; 
	}
}