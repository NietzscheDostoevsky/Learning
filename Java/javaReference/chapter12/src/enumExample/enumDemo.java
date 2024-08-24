package enumExample;

// An enumeration of apple varieties.
enum Mango {
    Langda, Malda, Alphonso, Deshari, Hapus,;
}

public class enumDemo {
    public static void main(String[] args) {
        Mango mg;
        mg = Mango.Alphonso;

        // output an enum value
        System.out.println("Value of mg : " + mg);
        System.out.println();

        mg = Mango.Deshari;

        // Comparing two enum values
        if (mg == Mango.Deshari)
            System.out.println("mg contains Deshari");

        // Use an enum to control a switch statement
        switch (mg) {
            case Langda :
                System.out.println("Langda is sweet");break;
            case Malda:
                System.out.println("Malda is sweeter");break;
            case Hapus:
                System.out.println("Hapus comes after");break;
            case Deshari:
                System.out.println("I Love Deshari");

        }

    }
}
