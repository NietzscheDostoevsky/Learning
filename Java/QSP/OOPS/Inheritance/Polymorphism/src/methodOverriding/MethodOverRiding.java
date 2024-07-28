package methodOverriding;

class RBI {
    public void roi() {
        double interestRate = 6.8;
        System.out.println("Rate of interest in RBI: " + interestRate + "%");
        
    }
}

class SBI extends RBI {
    public void roi() {
        double interestRate = 7.0;
        System.out.println("Rate of interest in SBI: " + interestRate + "%");
        
    }
}

class ICICI extends RBI {
    public void roi() {
        double interestRate = 7.5;
        System.out.println("Rate of interest in ICICI: " + interestRate + "%");
        
    }
}

public class MethodOverRiding {
    public static void main(String[] args) {
        RBI obj1 = new SBI(); 
        obj1.roi();
        
        RBI obj2 = new ICICI();
        obj2.roi();
    }
}
