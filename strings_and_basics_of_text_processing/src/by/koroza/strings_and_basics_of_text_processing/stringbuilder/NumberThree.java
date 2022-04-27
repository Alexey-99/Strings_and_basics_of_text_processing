/*Проверить, является ли заданное слово палиндромом. */

package by.koroza.strings_and_basics_of_text_processing.stringbuilder;

public class NumberThree {

	public static void main(String[] args) {
		String word = "Level";
		validationPalindromes(word);
	}

	private static void validationPalindromes(String word) {
		char[] symbols = word.toCharArray();
		symbols = toLowerCase(symbols);
		String wordLeftToRight = wordLeftToRight(symbols);
		String wordRightToleft = wordRightToLeft(symbols);
		if (wordLeftToRight.equals(wordRightToleft)) {
			System.out.println(word + " - this word is palindrome");
		} else {
			System.out.println(word + " - this word isn't palindrome");
		}
	}

	private static String wordLeftToRight(char[] symbols) {
		String wordLeftToRight = "";
		for (int i = 0; i < symbols.length; i++) {
			wordLeftToRight += symbols[i];
		}
		return wordLeftToRight;
	}

	private static String wordRightToLeft(char[] symbols) {
		String wordRightToleft = "";
		for (int i = symbols.length - 1; i >= 0; i--) {
			wordRightToleft += symbols[i];
		}
		return wordRightToleft;
	}

	private static char[] toLowerCase(char[] symbols) {
		for (int i = 0; i < symbols.length; i++) {
			if (Character.isUpperCase(symbols[i])) {
				symbols[i] = Character.toLowerCase(symbols[i]);
			}
		}
		return symbols;
	}
}