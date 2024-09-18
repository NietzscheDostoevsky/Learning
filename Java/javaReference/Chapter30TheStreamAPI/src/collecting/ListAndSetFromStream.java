package collecting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class NamePhoneEmail {
	String name;
	String phonenum;
	String email;

	NamePhoneEmail(String name, String phonenum, String email) {
		this.name = name;
		this.phonenum = phonenum;
		this.email = email;
	}

	@Override
	public String toString() {
		return "NamePhoneEmail [name=" + name + ", phonenum=" + phonenum + ", email=" + email + "]";
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

public class ListAndSetFromStream {
	public static void main(String[] args) {
		// A list of names, phone numbers, and e-mail addresses.
		ArrayList<NamePhoneEmail> myList = new ArrayList<>();
		myList.add(new NamePhoneEmail("Larry", "555-5555", "Larry@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("James", "555-4444", "James@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("Mary", "555-3333", "Mary@HerbSchildt.com"));

		// Map just the names and phone numbers to a new stream.
		Stream<NamePhone> nameAndPhone = myList.stream().map(a -> new NamePhone(a.name, a.phonenum));

		// Using collect to crate a List of the names and phone numbers.
		List<NamePhone> list = nameAndPhone.collect(Collectors.toList());
		System.out.println("Names and phone numbers in a List:");
		list.forEach(System.out::println);

		// Collecting in a set:
		Set<NamePhone> set = myList.stream().map(a -> new NamePhone(a.name, a.phonenum)).collect(Collectors.toSet());
		System.out.println("\nNames and phone numbers in a Set:");
		set.forEach(System.out::println);
		
		myList.forEach(a->System.out.println(a.name + " " + a.phonenum));
		
		
		// Specifically using LinkedList as the container to collect the stream. 
		
		LinkedList<NamePhone> ll = myList.stream()
										 .map(a -> new NamePhone(a.name, a.phonenum))
										 .collect(LinkedList::new, 
												 LinkedList::add, 
												 LinkedList::addAll);
		
		System.out.println(ll.size());
		System.out.println(ll.getClass().getName());
		
		// equivalent code using lambdas. 
		
		HashSet<NamePhone> hs = myList.stream()
									  .map(a -> new NamePhone(a.name, a.phonenum))
									  .collect( () -> new HashSet<NamePhone>(), 
											    (setA, element) -> setA.add(element), 
											    (setA, setB) -> setA.addAll(setB));
		
		System.out.println(hs.getClass());
		System.out.println(hs.getClass().getName());
		System.out.println(hs.size());
	}
}