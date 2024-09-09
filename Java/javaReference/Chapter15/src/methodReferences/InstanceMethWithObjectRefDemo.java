package methodReferences;

// Use an instance method reference with with different objects.

//Situation where you want to specify an instance method that
	//	can be used with any object of a given class, and 
	//	not just the specified object. 


// The first parameter of the functional interface matches
// 		the invoking object and the second parameter matches the 
// 		parameter specified by the method. 

interface MyFunc<T> {
	boolean func(T v1, T v2);
}

// A class that stores the temperature high for a day.
class HighTemp {
	private int hTemp;
	public HighTemp(int hTemp) { 
		this.hTemp = hTemp; }
	
	//Instance methods. 
	boolean sameTemp(HighTemp ht2) { return hTemp == ht2.hTemp; }
	boolean lessThanTemp (HighTemp ht2) { return hTemp < ht2.hTemp;	}
}

public class InstanceMethWithObjectRefDemo {
	
	static <T> int counter(T[]vals, MyFunc<T> f, T v) {
		int count = 0; 
		for (int i = 0; i < vals.length; i++)
			if (f.func(vals[i], v)) count++; 
		return count; 
	}
	
	public static void main(String[] args) {
		int count ; 
		HighTemp[] weekDayHighs = 
			  { new HighTemp(89), new HighTemp(82),
				new HighTemp(90), new HighTemp(89),
				new HighTemp(89), new HighTemp(91),
				new HighTemp(84), new HighTemp(83) };
		
		count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(89));
		System.out.println(count + " days had a high of 89");
		
		HighTemp[] weekDayHighs2 = 
			  { new HighTemp(32), new HighTemp(12),
				new HighTemp(24), new HighTemp(19),
				new HighTemp(18), new HighTemp(12),
				new HighTemp(-1), new HighTemp(13) };
		
		count = counter(weekDayHighs2, HighTemp::sameTemp,
				new HighTemp(12));
		System.out.println(count + " days had a high of 12");
		
		count = counter(weekDayHighs, HighTemp::lessThanTemp, new HighTemp(89));
		System.out.println(count + " days had a high less than 89");
		
		count = counter(weekDayHighs2, HighTemp::lessThanTemp,
				new HighTemp(19));
		System.out.println(count + " days had a high of less than 19");
	}
}



























