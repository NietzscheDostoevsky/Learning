public class Superclass {

    public static void main (String[] args){
        Superclass obj = new Subclass();
        obj.doSomething(); //prints "from Superclass"
    }

    private void doSomething(){System.out.println("from Superclass");}
}

class Subclass extends Superclass {

    private void doSomething(){System.out.println("from Subclass");}

}