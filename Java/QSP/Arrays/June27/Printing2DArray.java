import java.util.Arrays;
class Printing2DArray {
	public static void main(String[] args) {
		
		int [][] a = {{10, 20,30,40}, 
					  {50, 60, 70, 80, 90, 100}};

		System.out.println(a.length);
		System.out.println(a[0].length);
		System.out.println(a[1].length);

		for(int i = 0; i<a.length; i++){
			for(int j = 0; j<a[i].length; j++){
				System.out.print(a[i][j] + " ");
			}
		System.out.println();
		}

		for (int[] i :a){
			for (int j: i){
				System.out.print(j + " ");
			}
			System.out.println();
		}



		System.out.println(Arrays.deepToString(a));

		for (int [] i:a)
			System.out.println(Arrays.toString(i));
	}
}