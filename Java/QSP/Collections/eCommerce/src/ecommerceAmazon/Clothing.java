package ecommerceAmazon;

public class Clothing {
	Cart cart; 
	
	public Clothing() {
		this.cart = cart; 
	}
	
	public void products() {
		for (;;) {
			System.out.println("Welcome to clothing");
			System.out.println();
			System.out.println("1. Shirt (100)");
			System.out.println("2. TShirt (101)");
			System.out.println("3. Jeans (102)");
			System.out.println("4. Hoodie (103)");
			System.out.println("5. HomePage (0)");
			
			System.out.println();
			
			int option = Welcome.sc.nextInt();
			switch(option) {
				case 100 -> 
					{cart.list.add("shirt: 1200");
					System.out.println("Shirt added to the cart"); 
				}
				case 101 -> {
					cart.list.add("shirt: 1200");
					System.out.println("Shirt added to the cart"); 
				}
				case 102 -> {
					cart.list.add("shirt: 1200");
					System.out.println("Shirt added to the cart"); 
				}
				case 103 -> {
					cart.list.add("shirt: 1200");
					System.out.println("Shirt added to the cart"); 
				}
				case 104 -> {
					cart.list.add("shirt: 1200");
					System.out.println("Shirt added to the cart"); 
				}
			}
		}
	}
}
