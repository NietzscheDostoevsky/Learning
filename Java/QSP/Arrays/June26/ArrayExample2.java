import java.util.Arrays;

class ArrayExample2 {

	public static void main(String[] args) {

		int[][] a = new int[3][2];
		System.out.println(Arrays.deepToString(a));
		a[0][0] = 10;
		a[0][1] = 20;
		a[1][0] = 30;
		a[1][1] = 40;
		a[2][0] = 50;
		a[2][1] = 60;
		System.out.println(Arrays.deepToString(a));

		char[][] b = new char[2][];
		b[0] = new char[2];
		b[1] = new char[4];

		System.out.println(Arrays.deepToString(b));

		b[0][0] = 'A';
		b[0][1] = 'B';
		b[1][0] = 'C';
		b[1][1] = 'D';
		b[1][2] = 'E';
		b[1][3] = 'F';

		System.out.println(Arrays.deepToString(b));

		int[][] c = { { 1, 2 },
				{ 3, 4, 5, 6 } };
		System.out.println(Arrays.deepToString(c));

		int[][][] d = {
				{ { 10, 20, 30 } }, { { 40 }, { 50 } }, { { 60, 70 }, { 80, 90 }, { 100, 110 } } };
		System.out.println(Arrays.deepToString(d));

		int[][][] e = new int[3][][];
		e[0] = new int[1][3];
		e[1] = new int[2][1];
		e[2] = new int[3][2];
		System.out.println(Arrays.deepToString(e));

		// a[0][0][0] = 10;
		// a[0][0][1] = 20;
		// a[0][0][2] = 30;
		// a[1][0][0] = 40;
		// a[1][1][0] = 50;
		// a[2][0][0] = 60;
		// a[2][0][0] = 60;
		// a[2][0][0] = 60;

		int[][][] f = new int[2][1][];
		f[0][0] = new int[2];
		f[1][0] = new int[4];

		System.out.println(Arrays.deepToString(f));


	}
}