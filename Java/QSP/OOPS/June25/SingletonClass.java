// Factory design pattern : singleton 
// class that can be instantiated only once. 
// second time it is going to return the same object. 

class SingletonClass {

	static SingletonClass obj;

	private SingletonClass() {

	}

	public static SingletonClass getInstance() {
		if(obj == null){
			obj = new SingletonClass();
			return obj;
		}
		
		return obj;
	}

	public static void main(String[] args) {
		System.out.println(obj);
		SingletonClass obj = getInstance();
		System.out.println(obj);
		SingletonClass obj1 = getInstance();
		System.out.println(obj1);
		Ramesh.m1();
	}

}

class Ramesh {
	public static void m1() {
		SingletonClass obj = new SingletonClass();
		System.out.println(obj);
	}
}