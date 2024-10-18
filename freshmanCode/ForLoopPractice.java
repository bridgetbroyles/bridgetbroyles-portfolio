public class ForLoopPractice {
	public static void main(String[] args) {

		System.out.println("Reversed:" + ReverseDigit(12882));

		printFibs(16);

		printDigitTree(748108129);

		drawVase(5);

		drawVase(7);

		printFigure(5);

		printMultiples(11, 5);
		
		System.out.println();
		System.out.println("After flipping, it was the same " + timesAllSame(6) + " times.");
	}

	private static void printFibs(int N) {
		System.out.print("0 1 ");
		int num1 = 1;
		int num2 = 0;
		int temp;
		for (int i = 0; i < N - 2; i++) {
			System.out.print(num1 + num2 + " ");
			temp = num1;
			num1 += num2;
			num2 = temp;
		}
		System.out.println();
	}

	public static void printDigitTree(int digits) {
		String strdigits = digits + "";
		int rows = strdigits.length();
		for (int r = rows - 1; r >= 0; r--) {
			int repeatCount = r + 1;
			char currentDigit = strdigits.charAt(r);
			for (int c = 0; c < repeatCount; c++) {
				System.out.print(currentDigit);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int ReverseDigit(int digits) {
		int numDigits = (int) (Math.log10(digits) + 1);
		int reverse = 0;

		for (int i = 0; i <= numDigits; i++) {
			reverse = reverse * 10 + digits % 10;
			digits = digits / 10;
		}

		return reverse;
	}

	public static void drawVase(int size) {

		for (int i = 0; i < size * 3; i++)
			System.out.print("~");

		for (int i = 0; i < size * 3 - ((i + 1) * 2); i++)
			System.out.print(" ");

		drawVaseMiddle(size);

		for (int i = 0; i < size; i++)
			System.out.print("*");
		for (int i = 0; i < size; i++)
			System.out.print("~");
		for (int i = 0; i < size; i++)
			System.out.print("*");
		System.out.println();
	}

	private static void drawVaseMiddle(int size) {
		for (int i = 0; i < size; i++) {
			System.out.println();
			for (int c = 0; c < i; c++)
				System.out.print("*");
			System.out.print("(");
			for (int c = 0; c < (size * 3 - (2 * (i + 1))); c++)
				System.out.print(" ");
			System.out.print(")");
			for (int c = 0; c < i; c++)
				System.out.print("*");
		}
		System.out.println();
	}

	public static void printFigure(int size) {
		final int NUM_LINES = size * size;
		for (int line = 1; line <= NUM_LINES; line++) {
			for (int i = NUM_LINES - line; i > 0; i--) {
				System.out.print(".");
			}
			for (int i = 0; i < line; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void printMultiples(int value, int num) {
		String multiples = "";

		for (int i = 2; i <= num; i++) {
			multiples += ", " + (i * value);
		}

		System.out.println("The first " + num + " multiples of " + value + " are " + value
				+ multiples);

	}

	public static int timesAllSame(int numflipped) {

		int timeSame = 0;
		for (int i = 0; i < numflipped; i++)
			timeSame += (int) (Math.random() * 10) / 5;

		return timeSame;
	}

}
