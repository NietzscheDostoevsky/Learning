package com.Relationship;

class MyClass {
	// 
}


class FirstDerivedClass extends MyClass {
	int x ;
	// 
}

class SecondDerivedClass extends FirstDerivedClass {
	int y ; 
	// 
}

class TypeInferenceAndInheritance {
	// Return some type of MyClass object 
	
	static MyClass getObj(int which) {
		switch (which) {
		case 0: {
			return new MyClass();
		}
		case 1: {
			return new FirstDerivedClass();
		}
		
		default:
			return new SecondDerivedClass(); 
		}
	}
}
public class TypeInference {
	
	public static void main(String[] args) {
		
		var a = new int[10];
		System.out.println(a.getClass().getName());
		
		var b = "Haha";
		System.out.println(b.getClass().getName());
		
		var mc = TypeInferenceAndInheritance.getObj(0);
		var mc2 = TypeInferenceAndInheritance.getObj(1);
		var mc3 = TypeInferenceAndInheritance.getObj(2);
		
		System.out.println(mc.getClass().getName());
		System.out.println(mc2.getClass().getName());
		System.out.println(mc3.getClass().getName());
		
//		mc2.x = 10;
//		mc3.y = 10;
		
		
	}

}
