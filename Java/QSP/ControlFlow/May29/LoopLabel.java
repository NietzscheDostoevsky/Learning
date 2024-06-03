class LoopLabel{
	public static void main(String[] args) {
		
		// outer for loop 
        
        outerForLoop: 
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    break outerForLoop; 
                }
                System.out.println("i = " + i + ", j = " + j);
            }
        }

        //labels with while loop
        
        int a = 1;
        outerWhileLoop: 
        while (a <= 3) {
            int b = 1;
            while (b <= 3) {
                if (a == 2 && b == 2) {
                    break outerWhileLoop; 
                }
                System.out.println("a = " + a + ", b = " + b);
                b++;
            }
            a++;
        }

        // do while loop
        
        int x = 1;
        outerDoWhileLoop: 
        do {
            int y = 1;
            do {
                if (x == 2 && y == 2) {
                    break outerDoWhileLoop; 
                }
                System.out.println("x = " + x + ", y = " + y);
                y++;
            } while (y <= 3);
            x++;
        } while (x <= 3);
	}
}


