class Box {
	double width ; 
	double height ; 
	double depth ;

	// Constructor for Box
	Box(double width, double height, double depth) {
		this.width = width; 
		this.height = height; 
		this.depth = depth; 
	}

	double volume() {
		return width * height * depth ;
	}
}

class BoxDemoThis {
	public static void main(String[] args) {
		Box myBox1 = new Box(12.0, 12.0, 12.0);
		double vol = myBox1.volume();
		System.out.println(vol);
	}
}