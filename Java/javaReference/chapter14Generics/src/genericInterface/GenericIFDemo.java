package genericInterface;

// A generic interface example. 

// A min/max interface. 
interface MinMax<Type extends Comparable<Type>> {
	Type min();
	Type max();
}

// Now, implement MinMax
class MyClass<Type extends Comparable<Type>> implements MinMax<Type> {
	Type[] vals;
	
	public MyClass(Type[] obj) {
		this.vals = obj;
	}
	
	//Return the minimum value in vals
	public Type min() {
		Type v = vals[0];
		for (int i = 1; i < vals.length; i++)
			if (v.compareTo(vals[i]) < 0 )
				v = vals[i];
		return v;
	}
	
	public Type max() {
		Type v = vals[0];
		for (int i = 1; i < vals.length; i++)
			if (v.compareTo(vals[i]) > 0)
				v = vals[i];
		return v; 
	}
}

public class GenericIFDemo {

	public static void main(String[] args) {
		Integer[] inums = {3, 6, 2, 8, 6 };
		Character[] chs = {'b', 'r', 'p', 'w' };
		
		MyClass<Integer> iob = new MyClass<Integer>(inums);
		MyClass<Character> cob = new MyClass<Character>(chs);
		
		System.out.println("Max value in inums: " + iob.max());
		System.out.println("Min value in inums: " + iob.min());
		
		System.out.println("Max value in chs: " + cob.max());
		System.out.println("Min value in chs: " + cob.min());
	}

}
