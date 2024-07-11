package variables;

public class AskMe implements SharedConstants {

	static void answer(int result) {
		switch (result) {
		case NO: {

			System.out.println("NO");
			break;
		}
		case YES:
			System.out.println("Yes");
			break;
		case MAYBE:
			System.out.println("Maybe");
			break;
		case LATER:
			System.out.println("Later");
			break;
		case SOON:
			System.out.println("Soon");
			break;
		case NEVER:
			System.out.println("Never");
			break;

		}
	}

}
