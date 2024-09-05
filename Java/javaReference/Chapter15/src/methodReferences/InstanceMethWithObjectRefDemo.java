package methodReferences;

// Use an instance method reference with with different objects.

// A functional interface that takes two reference arguments. 
// 		and returns a boolean result.
interface MyFunc<T> {
	boolean func(T v1, T v2);
}

// A class that stores the temperature high for a day. 
class HighTemp {
	private int hTemp;
	
	public HighTemp(int hTemp) {
		this.hTemp = hTemp;
	}
	
	//Return true if the invoking HighTemp object has the same 
	// 	temperature as ht2; 
	
}

public class InstanceMethWithObjectRefDemo {
	
}
