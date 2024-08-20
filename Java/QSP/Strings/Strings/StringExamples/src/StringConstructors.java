public class StringConstructors {
    public static void main(String[] args) {


//        char [] arr = {'a', 'b', 'c', 'd'};
//        System.out.println(new String(arr));
//
//        String str1= "RAMESH";
//        StringBuffer sb = new StringBuffer(str1);
//        System.out.println(sb);
//        sb.reverse();
//        System.out.println(sb);
//        String str = new String(sb);
//        System.out.println(str.contentEquals(sb)?"Palindrome":"Not palindrome");

        String name = "saurabh";
        System.out.println(name.codePointAt(5));
        System.out.println(name.codePointBefore(6));
        System.out.println(name.codePointCount(5,7));

    }
}
