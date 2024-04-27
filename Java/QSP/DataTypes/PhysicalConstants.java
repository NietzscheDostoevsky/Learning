public class PhysicalConstants {
    public static void main(String[] args) {
        long light = 299_792_458L; 
        long second = 9192631770L ;
        long plancksConstant = 6_626_070_15L;
        long avogadro = 602214076L ;
        long  bohrRadius = 529177210903L ; 

        System.out.println("Speed of Light in Vacuum (m/s): " + light);
        System.out.println("hyperfine transition frequency of 133Cs (Hz)" + second);
        System.out.println("Planck's Constant (J s): " + plancksConstant);
        System.out.println("Avogadro's Number (mol^-1) x 10^15: " + avogadro);
        System.out.println("Bohr's radius" + bohrRadius);
    }
}
