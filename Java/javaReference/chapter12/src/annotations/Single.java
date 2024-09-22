package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// A single member annotation. 
@Retention(RetentionPolicy.RUNTIME)
@interface MySingle {
	int value(); // must be named value. 
}

public class Single {
	@MySingle(1000)
	public static void myMeth() {
		Single obj = new Single(); 
		
		try {
			System.out.println(obj.getClass()
								  .getMethod("myMeth")
								  .getAnnotation(MySingle.class)
								  .value());
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
}
