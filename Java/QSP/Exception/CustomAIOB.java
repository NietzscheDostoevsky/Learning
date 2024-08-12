public class CustomAIOB {
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		

		for(int i = 0; i <=arr.length; i++)
			if(i>arr.length -1 || i < 0)
				throw new MYArrayIndexOutOfBoundsException("Index check kar");
			else
				System.out.println(arr[i]);

	}
}

class MYArrayIndexOutOfBoundsException extends RuntimeException {
	MYArrayIndexOutOfBoundsException(String desc){
		super(desc);
	}
}

