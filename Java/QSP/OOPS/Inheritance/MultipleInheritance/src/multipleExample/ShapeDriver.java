package multipleExample;

class Shape {
    int l, b, h;
    
    Shape(){
    	
    }

    Shape(int l, int b, int h) {
        this.l = l;
        this.b = b;
        this.h = h;
    }

    int volume() {
    	System.out.println("shape");
        return l * b * h;
    }
}

class Cube extends Shape {
    Cube(int side) {
        super(side, side, side);
    }

    @Override
    int volume() {
    	System.out.println("cube");
        return l * l * l;
    }
}

class Triangle extends Shape {
	Triangle() {
		
	}
	int volume() {
		System.out.println("HAHAHAH");
		return 5; 
	}
}

public class ShapeDriver {
    public static void main(String[] args) {
        Shape shape = new Shape(2, 3, 4);
        System.out.println("Volume of Shape: " + shape.volume());
 

        Cube cube = new Cube(3);
        System.out.println("Volume of Cube: " + cube.volume());
        
        Shape c1 = new Cube(10); // upcasting 
        System.out.println(c1.volume());
        System.out.println(c1.b);
        c1 = (Cube) c1;  // DOWNCASTING
        System.out.println(c1.volume());
        
        
        
    }
}
