public class printfnotes {

	public static void main(String[] args) {
		String rightaligned = "right aligned";
		String leftaligned = "left aligned";
		double percent = 89.736;

		System.out.printf("'%30s'\n", rightaligned, "~");
		System.out.printf("'%-30s'%s\n", leftaligned, " wowza!");

		System.out.printf("%.2f%%\n", percent);

		/*
		 * Examples below are credited to Saul Gutierrez, the CS312 TA:
		 */

		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 10; j++) {
				System.out.printf("%4d", (i * j));
			}
			System.out.println();
		}

		/*
		 * Output: 1 2 3 4 5 6 7 8 9 10 2 4 6 8 10 12 14 16 18 20 3 6 9 12 15 18 21 24
		 * 27 30
		 */

		double pi = 3.141592653589793;
		System.out.printf("pi is %.1f\n", pi);
		System.out.printf("more precisely, %8.3f\n", pi);

		/*
		 * Output: pi is 3.1 more precisely, 3.142
		 */

		System.out.printf("%d\n", 10000);
		System.out.printf("%,d\n", 10000);

		/*
		 * Output: 10000 10,000
		 */
	}
}
