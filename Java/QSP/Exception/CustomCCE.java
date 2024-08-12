public class CustomCCE {
    public static void main(String[] args) {
        
        Object obj = new String(); 

        if (!(obj instanceof StringBuffer)) {
            throw new MYClassCastException("Object galat hai");
        } else {
            StringBuffer sb = (StringBuffer) obj;
        }
    }
}

class MYClassCastException extends RuntimeException {
    MYClassCastException(String desc) {
        super(desc);
    }
}
