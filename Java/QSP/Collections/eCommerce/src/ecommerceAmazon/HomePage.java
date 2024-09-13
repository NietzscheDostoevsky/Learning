package ecommerceAmazon;

public class HomePage {
	Clothing clothing = new Clothing();
	Electronics electronics = new Electronics();
	Footwear footwear = new Footwear();
	Cart cart = new Cart();
	CheckOut checkout = new CheckOut();
	User user;
	public HomePage(User user) {
		this.user = user;
	}
	
	public void shopByCategory() {
		System.out.println();
		System.out.println(" *** HOME PAGE ***");
		System.out.println();
		System.out.println("1. Clothing: ");
		System.out.println("2. Electronics");
		System.out.println("3. FootWear");
		System.out.println("4. Carts");
		System.out.println("5. Proceed to Checlout");
		System.out.println("6. Logout");
		System.out.println();
		
		System.out.println("Enter an option ");
		int option = Welcome.sc.nextInt();
		
		switch(option) {
		case 1 -> clothing.products();
		case 2 -> electronics.products();
		case 3 -> footwear.products();
		case 4 -> cart.viewCart();
		case 5 -> checkout.checkOut();
		
		}
	}
}
