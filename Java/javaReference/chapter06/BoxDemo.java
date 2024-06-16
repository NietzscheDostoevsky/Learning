/* A program that uses the Box class.
I
traPCall this file BoxDemo.java
*/
class Box {
	double width;
	double height;
	double depth;

	void volume(){
		System.out.print("Volume of the box is: ");
		System.out.println(width * height * depth);
	}
}
// This class declares an object of type Box.
class BoxDemo {
	public static void main(String[] args) {
		Box mybox1 = new Box();
		Box mybox2 = new Box(); 
		double vol;
		// assign values to mybox's instance variables
		mybox1.width = 10;
		mybox1.height = 20;
		mybox1.depth = 15;
		mybox1.volume() ;

		mybox2.width = 100;
		mybox2.height = 200;
		mybox2.depth = 150;
		mybox2.volume(); 
	}
}