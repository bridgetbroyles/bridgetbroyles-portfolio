import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class PrintWithoutHtml {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("web_page.html"));
		// printTextNoHTML(input);
		printTextNoHTML2(input);
	}

	public static void printTextNoHTML2(Scanner input) {
		System.out.println("2nd way: ");
		while (input.hasNextLine()) {
			String line = input.nextLine();
			while (line.contains("<") || line.contains(">")) {
				int index1 = line.indexOf("<");
				int index2 = line.indexOf(">");
				line = line.substring(0, index1) + line.substring(index2 + 1);
			}
			System.out.println(line.trim());
		}
	}

	public static void printTextNoHTML(Scanner input) {
		System.out.println("1st way: ");
		while (input.hasNextLine()) {
			String line = input.nextLine();
			String output = "";

			while (line.contains("<")) {
				int startIndex = line.indexOf("<");
				output += line.substring(0, startIndex);

				int endIndex = line.indexOf(">", startIndex);

				if (endIndex != -1) {
					line = line.substring(endIndex + 1);
				} else {
					break;
				}
			}

			output += line;

			System.out.println(output.trim());
		}
	}
}
