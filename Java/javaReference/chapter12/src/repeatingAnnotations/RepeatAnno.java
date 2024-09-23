package repeatingAnnotations;
// Demostrate a repeated annotation. 
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Make annotation repeatable. 
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatedAnnos.class)
@interface MyAnno {
	String str() default "Testing";
	int val() default 9000;
}

// This is the container annotation. 
@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatedAnnos {
	MyAnno[] value();
}

public class RepeatAnno {

	// Repeat MyAnno on myMeth(). 
	@MyAnno(str = "First annotation", val = -1)
	@MyAnno(str = "Second annotation", val = 100)
	
	public static void myMeth(String str, int i) {
		RepeatAnno obj = new RepeatAnno();
		try {
			Class<?> c = obj.getClass();
			Method m = c.getMethod("myMeth", String.class, int.class);
			System.out.println(m.getAnnotation(MyRepeatedAnnos.class));
		} catch (NoSuchMethodException  e) {
			e.printStackTrace();
		}	
	}
	public static void main(String[] args) {
		myMeth("test", 10);
	}
}
