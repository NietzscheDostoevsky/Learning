package objectClass;

import java.util.Objects;

public class Student {
	
	String name; 
	Student(String name) {
		this.name = name; 
	}

	// if not overriden, both the address and hashcode would be different. 
	// if overridden, it would be same, since toString implicitely calls toString. 
	/* public String toString(){
	      return getClass().getName() + '@' + Integer.toHexString(hashCode());
	   }
	 
	 */
	@Override
	public int hashCode() {
		// hash() ---> Objects
		return Objects.hash(name);
	}
	
	public static void main(String[] args) {
		Student s1 = new Student("Rahul"); 
		Student s2 = new Student("Rahul");
		
		System.out.println("Dummy address of first objet by compiler: " + s1);
		System.out.println("Dummy address of first objet by compiler: " + s2);
		System.out.println("Hash code -1 invoked by user: " + s1.hashCode());
		System.out.println("Hash code -2 invoked by user: " + s2.hashCode());
		
		
	}
}

// if not overriden, both the address and hashcode would be different. 
// if overridden, it would be same, since toString implicitely calls toString. 
/* public String toString(){
      return getClass().getName() + '@' + Integer.toHexString(hashCode());
   }
 
 */
