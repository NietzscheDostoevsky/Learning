import java.sql.SQLOutput;
import java.util.Arrays;

public final class MyString {
    String str = null;
    MyString(String str) {
        this.str = str;
    }
    MyString() {
        // no argument constructor
        str = "";
    }

    public int length() {
        int count = 0;
        for (int i = 0;true;i++) {
            try{
                str.charAt(i);
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }
        return count;
    }



    public boolean isEmpty() {
        if(str==null)
            throw new NullPointerException("String object not created.");
        if(str.length()==0)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return str;
    }

    public String toUpperCase() {
        String op = "";
        for (int i = 0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >=97 && ch<=122)
                op += (char)(ch-32);
            else
                op +=ch;
        }
        return op;
    }

    public String toLowerCase() {
        String op = "";
        for (int i = 0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >=65 && ch<=90)
                op += (char)(ch+32);
            else
                op +=ch;
        }
        return op;
    }

    public boolean startsWith(String check) {
        boolean starts = true;
        if (check.length() > str.length())
            return false;

        for (int i = 0; i < check.length(); i++)
            if (check.charAt(i) != str.charAt(i))
                return false;
        return starts;
    }

    public char charAt(int index) {
        if (index < 0 || index >= str.length())
            throw new IndexOutOfBoundsException("Wrong index entered");

        char[] arr = str.toCharArray();
        return arr[index];

    }

    public int codePointAt(int index) {
        if (index < 0 || index >= str.length())
            throw new IndexOutOfBoundsException("Wrong index entered");

        char[] arr = str.toCharArray();
        return arr[index];

    }

    //@Override
    public boolean equals(String input) {
        boolean flag = true;
        if (str.length() != input.length())
            return false;

        char[] temp = str.toCharArray();
        for (int i = 0; i < temp.length; i++ )
            if (temp[i] != input.charAt(i))
                return false;
        return true;
    }

    public boolean equalsIgnoreCase( String input) {
        String temp = input.toLowerCase();
        return str.toLowerCase().equals(temp);
    }

    public int codePointCount(String input, int start, int end) {
        if (end >= start)
            throw new IndexOutOfBoundsException("End can't be greater than begin");
        return end - start;
    }

    public char[] toCharArray() {
        int n = str.length();
        char[] ret = new char[n];
        for (int i = 0; i < n; i++)
            ret[i] = str.charAt(i);
        return ret;
    }

    public int indexOf(char ch) {
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ch)
                return i;
        return -1;
    }

    public int lastIndexOf(char ch) {
        for (int i = str.length()-1;i >=0; i--)
            if (str.charAt(i) == ch)
                return i;
        return -1;
    }

    public MyString concat(MyString obj) {
        String str1 = this.str;
        String newStr = str1 + obj;
        return new MyString(newStr);

    }

    public MyString substring(int beginIndex) {
        int N = str.length();

        if (beginIndex < 0 || beginIndex > N)
            throw new IndexOutOfBoundsException("beginIndex wrong");
        int len = N - beginIndex;
        char[] arr = new char[len];
        for (int i = 0; i < len; i++)
            arr[i] = str.charAt(beginIndex + i);
        return new MyString(new String(arr));
    }


    public MyString substring(int beginIndex, int endIndex) {
        int N = str.length();
        if (beginIndex < 0 || endIndex > N || beginIndex > endIndex)
            throw new IndexOutOfBoundsException("Index wrong");
        int len = endIndex - beginIndex;
        char[] arr = new char[len];
        for (int i = 0; i < len; i++)
            arr[i] = str.charAt(beginIndex + i);
        return new MyString(new String(arr));
    }


//    public MyString trim() {
//        int count = 0;
//        int N = str.length();
//        for ( int i = 0; i < N; i++)
//            if(isWhitespace(str.charAt(i)))
//                count++;
//        int retLen = N - count;
//        char[] arr = new char[retLen];
//        for ( int i = 0; i < N; i++)
//            if(!(isWhitespace(str.charAt(i))))
//                arr[i] = str.charAt(i);
//        String retStr = new String(arr);
//        return new MyString(retStr);
//
//    }
//    private boolean isWhitespace(char c) {
//        return c == ' ' || c == '\t' || c == '\n' || c == '\r' || c == '\f';
//    }



    public static void main(String[] args) {
        MyString mystr = new MyString("Saurabh");
        MyString mystr2 = new MyString("Singh");

        System.out.println(mystr.length());
        System.out.println(mystr.isEmpty());

        MyString str2 = new MyString();

        System.out.println(str2.isEmpty());
        System.out.println(mystr.toUpperCase());

        System.out.println(new MyString("HahaHehe").toUpperCase());
        System.out.println(new MyString("HahaHehe").toLowerCase());

        System.out.println(mystr.startsWith("Saur"));
        System.out.println(mystr.startsWith("saur"));

        System.out.println(mystr.charAt(0));
        System.out.println(mystr.charAt(2));

        System.out.println(mystr.codePointAt(0));
        System.out.println(mystr.codePointAt(2));

        System.out.println(mystr.equals("Saurabh"));
        System.out.println(mystr.equals("saurabh"));

        System.out.println(mystr.equalsIgnoreCase("saUrabh"));

        System.out.println(mystr.concat(mystr2));

        System.out.println(Arrays.toString(mystr.toCharArray()));

        System.out.println(mystr.substring(3));


//        System.out.println("-----------");
//        MyString trimCheck = new MyString("  ABCDEFGH   ");
//        System.out.println(trimCheck.trim());
    }
}


