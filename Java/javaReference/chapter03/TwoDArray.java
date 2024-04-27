// Demostrating 2D array 

class TwoDArray { 
    public static void main(String [] args ) {

        int [][] twoD = new int[4][5] ; // initialize the array 
        int i, j, k = 0 ; //  iniatialize counter 

        // for loop to fill the array 
        for (i=0; i<4; i++) { // outer loop for row index 
            for (j=0; j<5; j++) { // inner loop for column index 
                twoD[i][j] =  k ; 
                k ++ ;  
            }
        }

        // for loop to display the array 

        for (i=0;i<4;i++) { 
            for (j=0;j<5;j++) {
                System.out.println(twoD[i][j] + " "); // printing first row     
            }
            System.out.print();
        }
    }
}

