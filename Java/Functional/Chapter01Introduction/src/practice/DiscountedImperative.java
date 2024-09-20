package practice;

import java.util.Arrays;
import java.util.List;

public class DiscountedImperative {
	public static void main(String[] args) {
		final List<Integer> prices = Arrays.asList(10, 30, 17, 20, 18, 45, 12);
		
		// price > 20, discounted by 10% 
		double total = 0.0;
		for (int price: prices) {
			if (price > 20) {
				total += price * 0.9;
			}
		}
		System.out.println("Total of discounted prices: " + total);
		
		// functional way: 
		double total2 = prices.stream()
							  .filter(a->a>20)
							  .map(a->a*0.9)
							  .reduce(0.0, (a,b)->a+b);
		System.out.println(total2);
		
		double total3 = prices.stream()
							   .filter(price -> price > 20)
							   .mapToDouble(price -> price * 0.9)
							   .sum();
		
		System.out.println(total3);
	}
}
