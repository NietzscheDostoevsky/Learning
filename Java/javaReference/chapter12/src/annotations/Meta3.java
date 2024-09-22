package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno3 {
	String str() default "Tesitng";
	int val() default 9000;
}

public class Meta3 {
	
	@MyAnno3() // () has to be applied. 3
	public static void myMeth() {
		Meta3 obj = new Meta3(); 
		
		try {
			Class<?> c = obj.getClass();
			Method m = c.getMethod("myMeth"); 
			MyAnno3 anno = m.getAnnotation(MyAnno3.class);
			System.out.println(anno.str() + " " + anno.val());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Meta3.myMeth();
	}
}
