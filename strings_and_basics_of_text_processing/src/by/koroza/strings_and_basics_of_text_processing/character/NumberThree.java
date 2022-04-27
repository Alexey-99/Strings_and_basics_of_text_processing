/*В строке найти количество цифр. */

package by.koroza.strings_and_basics_of_text_processing.character;

public class NumberThree {

	public static void main(String[] args) {
		String line = "1 He3llo wosdgvsdxv46436345rld 9";
		System.out.println("В строке " + countDigits(line) + " цифр.");
	}

	private static int countDigits(String line) {
		char[] symbols = line.toCharArray();
		int countDigits = 0;
		for (int i = 0; i < symbols.length; i++) {
			if (Character.isDigit(symbols[i])) {
				countDigits++;
			}
		}
		return countDigits;
	}
}