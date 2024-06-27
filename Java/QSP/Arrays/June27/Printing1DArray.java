import java.util.Arrays;
class Printing1DArray {
	public static void main(String[] args) {
		
			int[] arr = {10, 20, 30};

			int l = arr.length;
			for( int i = 0; i<l; i++){
				System.out.println(arr[i]);
			}

			int j = 0;
			while(j<l) {
				System.out.println(arr[j]);
				j++;
			}

			int k = 0;
			do{
				System.out.println(arr[k]);
				k++;
			} while(k < l);

			for(int i: arr) {
				System.out.println(i);
			}

			// using to string 
			System.out.println(Arrays.toString(arr));


	}
}