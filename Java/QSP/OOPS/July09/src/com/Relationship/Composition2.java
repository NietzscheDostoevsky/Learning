package com.Relationship;

class WhiteBoard {
	
	String brand = "GURJAN";
	String dim = "15 x 4 "; 
	double price = 10_000;	
	Marker marker;
	Duster duster;
	
	void displayBoard() {
		System.out.println("Brand: " + brand);
		System.out.println("Dimensions" + this.dim);
		System.out.println("Price" + this.price);
		System.out.println();
	}
	
	void addMarker() {
		marker = new Marker();
	}
	
	void addDuster() {
		duster = new Duster();
	}
}

class Marker {
	String brand = "CAMLIN";
	String type = "White board maerker"; 
	String color = "black" ; 
	double price = 40;;
	
	void displayMarker() {
		System.out.println("Brand" + this.brand);
		System.out.println("Type" + this.type);
		System.out.println("Color" + this.color);
		System.out.println("Price" + this.price);
	}
}

class Duster {
	String brand = "Polo";
	double price = 150;
	String material = "Plastic";
	
	void displayDuster() {
		System.out.println("Brand" + this.brand);
		System.out.println("Price: " + this.price);
		System.out.println("Material: " + this.material);
	}
}


class Composition2 {
	public static void main(String[] args) {
		
		WhiteBoard w = new WhiteBoard();
		w.displayBoard();
		//w.marker.displayMarker();
		w.addMarker();
		w.marker.displayMarker();
		w.addDuster();
		w.duster.displayDuster();
		
		
		
		
	}
}
