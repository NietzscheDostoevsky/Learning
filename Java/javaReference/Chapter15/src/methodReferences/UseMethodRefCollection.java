package methodReferences;

import java.util.ArrayList;
import java.util.Collections;

// Use a method reference to find the max value in a collection. 

class MyClass {
	private int val; 
	MyClass(int val) { this.val = val;} //constructor
	int getVal() { return this.val;} 	//getter
}

public class UseMethodRefCollection {
	
	//A compare() method compatible with the one defined by Comparator<T>
	static int compareMC(MyClass a, MyClass b) {
		return a.getVal() - b.getVal();
	}

	public static void main(String[] args) {
		ArrayList<MyClass> list = new ArrayList<MyClass>(); 
		
		list.add(new MyClass(1));
		list.add(new MyClass(4));
		list.add(new MyClass(2));
		list.add(new MyClass(9));
		list.add(new MyClass(3));
		list.add(new MyClass(7));
		list.add(new MyClass(10));
		
		// Find the maximum using compareMC method
		MyClass maxValObj = Collections.max(list, UseMethodRefCollection::compareMC);
		MyClass minValObj = Collections.max(list, (o1,o2)->(o2.getVal()-o1.getVal()));
		System.out.println(maxValObj.getVal());
		System.out.println(minValObj.getVal());
	}

}

// MyClass neither defines any comparison method, nor does it implements Comparator. 
// But, the max val of the list of MyClass items can still be obtained by calling max()
// because UseMethodRefCollection defines the static method compareMC() 
// which is compatible with the compare() method defined by the Comparator. 
