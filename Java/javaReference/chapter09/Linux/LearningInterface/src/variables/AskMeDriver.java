package variables;

public class AskMeDriver {
	public static void main(String[] args) {
		
		Question question = new Question();
		
		AskMe.answer(question.ask());
		AskMe.answer(question.ask());
		AskMe.answer(question.ask());
		AskMe.answer(question.ask());
		AskMe.answer(question.ask());
		
	}

}
