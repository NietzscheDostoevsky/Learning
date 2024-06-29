import java.util.Arrays;
class Array2Dto1D {
	public static void main(String[] args) {
		
		int[][] a = {
			{1,2,3},
			{4,5,6,7,8},
			{9,10,11,12,13}
		};

		System.out.println(Arrays.deepToString(a));
		int sumLength = 0;
		for(int[] i:a){
			sumLength += i.length ;
		}

		int[] b = new int[sumLength];
		int indx = 0;
		for(int[] i:a){
			for(int j : i){
				b[indx++] =j;
			}
		}

		System.out.println(Arrays.toString(b));

		
	}
}