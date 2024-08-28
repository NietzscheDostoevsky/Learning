import java.util.Scanner;

class freq2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter some string: ");
        StringBuffer sb = new StringBuffer(sc.nextLine().toLowerCase());

        System.out.println("Before: " + sb);

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            int count = 1;
            boolean isSeenBefore = false;

            for (int j = 0; j < i; j++) {
                if (sb.charAt(j) == ch) {
                    isSeenBefore = true;
                    break;
                }
            }


            if (!isSeenBefore) {
                for (int j = i + 1; j < sb.length(); j++) {
                    if (sb.charAt(j) == ch) {
                        count++;
                    }
                }
                System.out.println(ch + " : " + count);
            }
        }
    }
}
