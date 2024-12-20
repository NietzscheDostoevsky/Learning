package boundedWildcards;

// generic class "Coords" which stores an 
// array of coordinates 
public class Coords<Type extends TwoD> {
	Type[] coords;

	public Coords(Type[] o) {
		this.coords = o;
	}

	static void showXY(Coords<?> c) {
		System.out.println("X Y coordinates: ");
		for (int i = 0; i < c.coords.length; i++) {
			System.out.println(c.coords[i].x +" " 
							 + c.coords[i].y);
			System.out.println();
		}
	}

	static void showXYZ(Coords<? extends ThreeD> c) {
		System.out.println("X Y Z Coordinates:");
		for (int i = 0; i < c.coords.length; i++)
			System.out.println(c.coords[i].x + " " + 
							   c.coords[i].y + " " + 
							   c.coords[i].z);
		System.out.println();
	}
	
	static void showAll(Coords<? extends FourD> c) {
		System.out.println("X Y Z T Coordinates:");
		for(int i=0; i < c.coords.length; i++)
			System.out.println(c.coords[i].x + " " +
		c.coords[i].y + " " +
		c.coords[i].z + " " +
		c.coords[i].t);
		System.out.println();
	}
}
