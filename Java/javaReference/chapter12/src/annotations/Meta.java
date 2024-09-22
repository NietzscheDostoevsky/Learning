package annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// An annotation type dexlaration. 
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
	String str(); 
	int val(); 
}

public class Meta {
	//Annotate a method. 
	@MyAnno(str = "Two parameters", val = 19)
	public static void myMeth(String str, int i) {
		Meta obj = new Meta();
		
		// Obtain the annotation for this method and display the values of the members. 
		
		try {
			Class<?> c = obj.getClass();
			Method m = c.getMethod("myMeth", String.class, int.class);
			System.out.println(int.class);
			MyAnno anno = m.getAnnotation(MyAnno.class);
			System.out.println(anno);
			System.out.println(anno.str() + " " + anno.val());
			System.out.println(Meta.class);
			System.out.println(String.class);
		} catch (NoSuchMethodException e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		myMeth("test", 10);
	}
}
