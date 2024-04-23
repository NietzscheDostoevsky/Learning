public class ScratchPad {
    public static void main(String[] args) {
        int intValue = 300; // This value is larger than the range of a byte
        byte byteValue = (byte) intValue; // Casting int to byte
        byte a = 40;
        byte b = 50;
        byte c = 100;
        int d = a * b / c;
        System.out.println(d + " is of type " + ((Object) d).getClass().getSimpleName());

        String name = "John";
        System.out.println("Variable type of name: " + name.getClass().getSimpleName());

    }
}
