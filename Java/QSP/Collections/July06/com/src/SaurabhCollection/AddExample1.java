package SaurabhCollection;

import java.util.ArrayList;

public class AddExample1 {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		for(int i = 10; i <=200; i+=10) {
			arrayList.add(i);
		}
		System.out.println(arrayList);
	}
}
