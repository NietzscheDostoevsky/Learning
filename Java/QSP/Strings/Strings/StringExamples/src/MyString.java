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


    public static void main(String[] args) {
        MyString mystr = new MyString("Saurabh");
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

    }
}


