package arrayListImplementation;

public class ArrayListDriver {

	public static void main(String[] args) {
		
		MyArrayList<Integer> mal = new MyArrayList<>(); 
		System.out.println(mal);
		
		mal.add(10);
		mal.add(20);
		mal.add(30);
		mal.add(40);
		System.out.println(mal);
		mal.add(50);
		mal.add(60);
		mal.add(70);
		mal.add(80);
		mal.add(90);
		mal.add(100);
		System.out.println(mal);
		mal.add(1100);
		mal.add(1200);
		
		System.out.println(mal);
		
		System.out.println(mal.indexOf(70));
		System.out.println(mal.indexOf(0));
		
	}

}
