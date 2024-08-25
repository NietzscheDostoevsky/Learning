package twoTypeParametersExample;

public class TwoGen<Type, Value> {
	Type ob1; 
	Value ob2; 
	
	public TwoGen(Type o1, Value o2) {
		this.ob1 = o1;
		this.ob2 = o2; 
	}
	
	Type getOb1() {
		return ob1; 
	}
	
	Value getOb2() {
		return ob2; 
	}
	
	void showTypes() {
		System.out.println("Type of T is :" +
				ob1.getClass().getName());
		System.out.println("Type of V is :" +
				ob2.getClass().getName());

		
	}
}
