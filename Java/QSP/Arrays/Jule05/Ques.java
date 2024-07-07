import java.util.Arrays;
class Ques {
	public static void main(String[] args) {
		
		int[] arr = {1,1,1,2,3,4,4};
		int N = arr.length;
        for (int i = 0; i < N; i++) {

            boolean isNonUnique = false;
            
            if (i < N - 1 && arr[i] == arr[i + 1]) {
                isNonUnique = true;
            }
            
            while (i < N - 1 && arr[i] == arr[i + 1]) {
                i++;
            }
            if (isNonUnique) {
                System.out.println(arr[i]);
            }
        }

	}


}

