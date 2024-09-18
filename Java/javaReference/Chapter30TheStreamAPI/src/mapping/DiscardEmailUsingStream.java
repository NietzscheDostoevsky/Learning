package mapping;

import java.util.ArrayList;
import java.util.stream.Stream;

// Class NamePhoneEmail contains name, phone, and email. 
// using streams and map, discard email in a new object
// that would only contain name and phone

class NamePhoneEmail {
	String name;
	String phonenum;
	String email;

	NamePhoneEmail(String name, String phonenum, String email) {
		this.name = name;
		this.phonenum = phonenum;
		this.email = email;
	}
}

class NamePhone {
	String name;
	String phonenum;

	public NamePhone(String name, String phonenum) {
		this.name = name;
		this.phonenum = phonenum;
	}

	@Override
	public String toString() {
		return "NamePhone [name=" + name + ", phonenum=" + phonenum + "]";
	}
	
}

public class DiscardEmailUsingStream {
	public static void main(String[] args) {
		// A list of names, phone numbers, and e-mail addresses.
		ArrayList<NamePhoneEmail> myList = new ArrayList<>();
		myList.add(new NamePhoneEmail("Larry", "555-5555", "Larry@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("James", "555-4444", "James@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("Mary", "555-3333", "Mary@HerbSchildt.com"));

		System.out.println("Original values in myList: ");
		myList.stream().forEach(a -> System.out.println(a.name + " " + a.phonenum + " " + a.email));

		// Map just the names and phone numbers to a new stream.
		Stream<NamePhone> nameAndPhone = myList.stream().map(a -> new NamePhone(a.name, a.phonenum));
		nameAndPhone.forEach((a) -> System.out.println(a.name + " " + a.phonenum));
		
		// using map and filter together. 
		
		nameAndPhone = myList.stream()
							 .filter(a->a.name.equals("James"))
							 .map(a -> new NamePhone(a.name, a.phonenum));
		nameAndPhone.forEach(System.out::println);
							 
	}
}
