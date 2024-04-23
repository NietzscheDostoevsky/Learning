public class ScratchPad {
    public static void main(String[] args) {
        int intValue = 300; // This value is larger than the range of a byte
        byte byteValue = (byte) intValue; // Casting int to byte

        System.out.println("Original int value: " + intValue);
        System.out.println("Casted byte value: " + byteValue);
    }
}
