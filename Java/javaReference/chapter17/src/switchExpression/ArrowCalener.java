package switchExpression;

public class ArrowCalener {

	public static void main(String[] args) {
		
		String monthString = "January";
		
		String weather = switch(monthString.toLowerCase()) {
		case "november", "december", "january", "february", "march" -> "winter";
		case "april", "may", "june", "july" -> "summer";
		case "august", "september", "october" -> "rainy";
		default -> "wrong weather";
		};
		
		System.out.println(weather);
	}

}
