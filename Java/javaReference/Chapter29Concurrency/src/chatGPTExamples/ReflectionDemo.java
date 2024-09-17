package chatGPTExamples;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

class Example {
    private String message;

    public Example() {
        this.message = "Hello!";
    }

    public void printMessage() {
        System.out.println(this.message);
    }
    public String getMessage() {
    	return this.message;
    }
}

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        // Get the Class object
    	// Fully qualified className to be provided here.
    	System.out.println("Methods: ");
        Class<?> cls = Class.forName("chatGPTExamples.Example");
      
        Method[] methods = cls.getDeclaredMethods();
        Arrays.asList(methods).forEach(x->System.out.println(x.getName()));
        
        // Get declared fields. 
        Field[] fields = cls.getDeclaredFields();
        System.out.println("Fields: ");
        Arrays.asList(fields)
        	  .stream()
        	  .map(Field::getName)
        	  .forEach(System.out::println);
        for (var x : fields) 
        	System.out.println(x.getName());
        
        // Create an instance of the class. 
        Constructor<?> constructor = cls.getConstructor();
        Object obj = constructor.newInstance();
        
        // Call a method dynamically. 
        Method method = cls.getMethod("printMessage");
        method.invoke(obj);
        
    }
}
