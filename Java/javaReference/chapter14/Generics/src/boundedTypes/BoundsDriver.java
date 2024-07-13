package boundedTypes;

public class BoundsDriver {
	public static void main(String[] args) {
		
		
		Stats<Integer> iob ; 
		Integer[] inums = {1,2,3,4,5};
		iob = new Stats<Integer>(inums);
		
		System.out.println(iob.average());
		
		Double[] dnums = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		Stats<Double> dob = new Stats<Double>(dnums);
		System.out.println(dob.average());
		
		//String[] strs = { "1", "2", "3", "4", "5" };
		//Stats<String> strob = new Stats<String>(strs);
		
		Float[] fnums = { 1.0F, 2.0F, 3.0F, 4.0F, 5.0F };
		Stats<Float> fob = new Stats<Float>(fnums);
		System.out.println(fob.average());
		
		if(iob.isSameAvg(fob)) {
			System.out.println("same average");
		} else {
			System.out.println("Differetn average");
		}
		
		if(dob.isSameAvg(fob)) {
			System.out.println("same average");
		} else {
			System.out.println("Differetn average");
		}
		
		
		
	}
}

