package boundedWildcards;

//Two Dimensional coordinates 

public class TwoD {
	int x, y; 
	
	// Constructor 
	TwoD(int x, int y) {
		this.x = x; 
		this.y = y; 
	}
	
}
// Three dimensional coordinates
class ThreeD extends TwoD {
	int z;
	
	// constructor
	public ThreeD(int x, int y, int z) {
		super(x, y);
		this.z = z ;
	}	
}

//four dimensional coordinates 

class FourD extends ThreeD {
	//constructor
	int t; 
	public FourD(int x, int y, int z, int t) {
		super(x, y, z);
		this.t = t;
	}
}




