package lambdaExpressionsAndExceptions;

import java.util.Arrays;
import java.util.Comparator;

public class DescendingArraySort {
	
	public static void main(String[] args) {
		
		Integer [] arr = {3,4,2,5,1,6};
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr,new DescSort());
		
		System.out.println(Arrays.toString(arr));
	}

}
class DescSort implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2-o1;
	}
	
}