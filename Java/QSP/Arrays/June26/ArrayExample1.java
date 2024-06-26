import java.util.Arrays;
class ArrayExample1 {
	public static void main(String[] args) {
		
		int [][] a = new int[2][2];
		System.out.println(a);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.deepToString(a));

		int [][] b = new int[3][];
		b[0] = new int[2];
		b[1] = new int[3];
		b[2] = new int[2];

		System.out.println(Arrays.deepToString(b));

		int[][][] c = new int[3][3][2];
		System.out.println(Arrays.deepToString(c));

		int [][][] d = new int[2][][];
		d[0] = new int[1][3];
		d[1] = new int[2][];
		d[1][0] = new int[2] ;
		d[1][1] = new int[1];
		System.out.println(Arrays.deepToString(d));

		int[][][] e = new int[2][][];
		e[0] = new int[2][];
		e[0][0] = new int[2];
		e[0][1] = new int[1];

		e[1] = new int[3][];
		e[1][0] = new int[1];
		e[1][1] = new int[2];
		e[1][2] = new int[3];
		System.out.println("*---------------*");
		System.out.println(Arrays.deepToString(e));


	}
}