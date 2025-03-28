/*
 * Write a method named printBox that accepts two parameters: a Scanner representing an input file, and an integer representing the length of the longest line of input in that file. Your method should print the contents of the file to the console, but print them inside a box figure. For example, if the file example.txt contains the following input data:
This is some
text here.
Then the following would be the output of your method, when passed a Scanner on that file and the integer 12 as parameters:
 * 
 */

//assume Scanner is reading from a file of just strings

import java.util.Scanner;
public static void printBox(Scanner input, int linelength) {

	System.out.print("+");
	for (int i = 0; i <= linelength + 1; i++)
		System.out.print("-");
	System.out.println("+");

	while (input.hasNextLine()) {
		System.out.print("| ");
		String line = input.nextLine();

		while (line.length() <= linelength - 1)
			line = line + " ";

		System.out.print(line);
		System.out.println(" |");

	}

	System.out.print("+");
	for (int i = 0; i <= linelength + 1; i++)
		System.out.print("-");
	System.out.print("+");

}
