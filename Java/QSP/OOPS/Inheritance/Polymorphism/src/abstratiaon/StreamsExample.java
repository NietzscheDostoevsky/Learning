package abstratiaon;

import java.util.Arrays;

public class StreamsExample {
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5,6,7};
		Arrays.stream(arr).filter(ele->ele%2==0).forEach(ele->System.out.println(ele));
	}
}
