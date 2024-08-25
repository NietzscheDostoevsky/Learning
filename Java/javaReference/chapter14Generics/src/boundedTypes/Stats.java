package boundedTypes;

public class Stats<Type extends Number & Comparable<Type>> {
	
	Type[] nums; // array of Number or a subclass of Number 
	Stats(Type[] obj) { // Defining constructor
		this.nums = obj;
	}
	
	// return type double in all cases. 
	double average() {
		double sum = 0.0;
		for(int i = 0; i < nums.length; i++) 
			sum += nums[i].doubleValue(); 
		return sum / nums.length;
	}
	
	// Demonstrating wild-card usage 
	
	// Determine if the averages are the same. 
	
	boolean isSameAvg(Stats<?> ob) {
		if (this.average() == ob.average()) 
			return true; 
		return false;
	}	
}
