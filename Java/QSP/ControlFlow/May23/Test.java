class Test{    
    public static void main(String[] args) {
        int n = 4; 
        char alpha = 'a';
        int num = 8 ; 

        for(int i = 0 ; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i % 2 == 0){
                    System.out.print(alpha);
                    alpha++;
                } else {
                    System.out.print(num);
                    num--;
                }
            }
            System.out.println();
        }

    }
}