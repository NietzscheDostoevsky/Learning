package arrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListConstructorExample {

	public static void main(String[] args) {
		
		ArrayList<Integer> a1 = new ArrayList<>();
		System.out.println(a1.size());
		System.out.println();
		a1.add(10);
		for (int i = 10; i<110; i+=10)
			a1.add(i);
		System.out.println(a1.size());
		
		int[] arr = {4,3,2,1};
		Arrays.sort(arr);

	}

}
