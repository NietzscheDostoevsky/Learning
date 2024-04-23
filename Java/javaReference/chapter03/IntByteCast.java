public class IntByteCast {
    public static void main(String[] args) {
        int intValue = 300; // This value is larger than the range of a byte
        byte byteValue = (byte) intValue; // Casting int to byte

        System.out.println("Original int value: " + intValue);
        System.out.println("Casted byte value: " + byteValue);
    }
}

// Output
/*
 * Original int value: 300
 * Casted byte value: 44
 */

// EXPLANATION
// **********************

/*
 * 
 * 1. **Original Integer Value**: `intValue = 300`
 * 2. **Range of a Byte**: Bytes in Java have a range from -128 to 127.
 * 3. **Modulo Operation**: When casting an integer to a byte, the integer value
 * is reduced modulo 256 (the range of a byte).
 * 
 * Here's how the modulo operation works:
 * 
 * - `300 % 256 = 44`
 * 
 * Explanation:
 * - When `300` is divided by `256`, the quotient is `1` and the remainder is
 * `44`.
 * - Therefore, `300 % 256 = 44`.
 * 
 * So, when casting `300` to a `byte`, the value `44` is retained, as it fits
 * within the range of a byte (-128 to 127). This is why the casted byte value
 * is `44` in the output.
 * 
 */