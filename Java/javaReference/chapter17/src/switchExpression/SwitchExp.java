package switchExpression;

public class SwitchExp {

	public static void main(String[] args) {
		
		int eventCode = 6010;
		int priorityLevel = switch(eventCode) {
		case 1000, 6010, 9129:
			yield 1; 
		case 1002, 3293, 2323:
			yield 2; 
		default : 
			yield 3; 
		};
		
		System.out.println(priorityLevel);
		
		int priorityArrow = switch(eventCode) {
		case 1000, 6010, 9129 -> 1; 
		case 3223, 2242, 2342 -> 2 ; 
		default -> 0;
		};
		System.out.println(priorityArrow);

	}
	
	

}
