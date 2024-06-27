class ArrayLength {
	public static void main(String[] args) {
		
		int[][] arr = {{ 2, 3,4, 5} , { 5,6,7, 5}}; 

		int first = 0 ;
		int second = 0 ;

		outer: for(int i = 0; ; i++){
			try{
				int a[] = arr[i];
				first++;

				if(i==0){
					inner: for(int j = 0; ; j++){
						try{
							int b = arr[i][j];
							second++;
						}catch(ArrayIndexOutOfBoundsException e1){
							break inner;
					}
				}

				}

				
			}catch(ArrayIndexOutOfBoundsException e) {
				break outer;
			}
		}

		System.out.println(first); // 2
		System.out.println(second); // 3
	}
}