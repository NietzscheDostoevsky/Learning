// Calculated the distance light travels using long variables

class Light {
    public static void main(String[] args) {

        int lightspeed ;
        long days ;
        long seconds ;
        long distance ;

        // approx speed of light in mpsecond 
        lightspeed = 186000; 
        days = 1000; 
        seconds = days * 24 * 60 * 60 ; 
        distance = lightspeed * seconds ; 

        System.out.print("In " + days ) ; 
        System.out.print( " days light will travel about ") ; 
        System.out.println(distance + " miles.") ; 
    }
}