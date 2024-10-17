/*
  * Since my professor requested that our projects are not uploaded online in any shape or form,
  * I decided to create a reverse version of the Hangman project we did the week
  * This version is not robust or intelligent and simply guesses randomly,
  * however, it was good practice for string concetenation and Scanners.
*/

import java.util.Scanner;
import java.util.Random;

public class ReverseHangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wordLength = getWordLength(scanner);
        String guessedWord = createInitialWord(wordLength);
        playGame(scanner, guessedWord);
        scanner.close();
    }

    public static int getWordLength(Scanner scanner) {
        System.out.print("How many letters are in the word you're thinking of? ");
        return scanner.nextInt();
    }

    public static String createInitialWord(int length) {
        String result = "";
        for (int i = 0; i < length; i++) {
            result += "_";
        }
        return result;
    }

    public static void playGame(Scanner scanner, String guessedWord) {
        String guessedLetters = "";
        Random random = new Random();
        boolean wordGuessed = false;

        while (!wordGuessed && guessedLetters.length() < 26) {
            char guessedLetter = getRandomLetter(random, guessedLetters);
            guessedLetters += guessedLetter;
            guessedWord = processGuess(scanner, guessedWord, guessedLetter);
            wordGuessed = !guessedWord.contains("_");
            System.out.println("Current guessed word: " + guessedWord);
        }

        if (wordGuessed) {
            System.out.println("Yay! I guessed the word: " + guessedWord);
        } else {
            System.out.println("Out of guesses. Better luck next time!");
        }
    }

    public static char getRandomLetter(Random random, String guessedLetters) {
        char randomLetter;
        do {
            randomLetter = (char) (random.nextInt(26) + 'a');
        } while (guessedLetters.indexOf(randomLetter) != -1);
        return randomLetter;
    }

    public static String processGuess(Scanner scanner, String guessedWord, char guessedLetter) {
        System.out.println("I guess the letter: " + guessedLetter);
        System.out.print("Is this letter in your word? (yes/no): ");
        String response = scanner.next().toLowerCase();
        scanner.nextLine();

        if (response.equals("yes")) {
            System.out.print("At which positions is this letter in the word? (Enter positions separated by spaces): ");
            String[] positions = scanner.nextLine().split(" ");
            guessedWord = updateWord(guessedWord, guessedLetter, positions);
        } else {
            System.out.println("OK, I'll try another letter.");
        }

        return guessedWord;
    }

    public static String updateWord(String word, char letter, String[] positions) {
        String newWord = "";
        for (int i = 0; i < word.length(); i++) {
            boolean found = false;
            for (String pos : positions) {
                // Avoiding parseInt by converting char to int and comparing
                if (i == (pos.charAt(0) - '1')) {
                    newWord += letter;
                    found = true;
                    break;
                }
            }
            if (!found) {
                newWord += word.charAt(i);
            }
        }
        return newWord;
    }
}
