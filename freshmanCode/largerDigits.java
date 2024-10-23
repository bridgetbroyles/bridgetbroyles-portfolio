public class largerDigits {

	public static void main(String[] args) {
		System.out.print(largerDigits(8921, 97325));
		// returns 98925
	}

	public static int largerDigits(int a, int b) {
		int c = 0;
		int placeValue = 1;

		while (a > 0 || b > 0) {
			int digitA = a % 10;
			int digitB = b % 10;

			int largerDigit = Math.max(digitA, digitB);

			c += largerDigit * placeValue;

			placeValue *= 10;

			a /= 10;
			b /= 10;
		}

		return c;
	}
}
