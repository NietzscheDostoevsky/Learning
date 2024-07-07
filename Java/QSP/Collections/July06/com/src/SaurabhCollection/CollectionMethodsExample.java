package SaurabhCollection;
import java.util.ArrayList;
import java.util.Collection;

public class CollectionMethodsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("haha")

		ArrayList arrayList = new ArrayList();
		arrayList.add(40);
		arrayList.add(50);
		arrayList.add(60);
		
		// ArrayList collection = new ArrayList();
		
		Collection collection =  new ArrayList();
		System.out.println(collection);
		collection.add(10);
		collection.add(30);
		collection.add(20);
		System.out.println(collection);
		
		collection.addAll(arrayList);
		System.out.println(collection);
		
		

	}

}
