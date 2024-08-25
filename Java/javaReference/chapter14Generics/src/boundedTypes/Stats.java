package boundedTypes;

public class Stats<T extends Number> {
	
	T[] nums; // array of Number or a sublclass of Number 
	Stats(T[] obj) { // defiining constructor
		this.nums = obj;
	}
	
	// return type double in all cases. 
	double average() {
		double sum = 0.0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i].doubleValue(); 
		}
		return sum / nums.length;
	}
	
	// demostrating wildcard usage 
	
	// Deterine if the averages are the same. 
	
	boolean isSameAvg(Stats<?> ob) {
		if(this.average() == ob.average()) {
			return true; 
		}
		
		return false;
	}
	
	
	
}
