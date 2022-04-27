/* С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”. */

package by.koroza.strings_and_basics_of_text_processing.stringbuilder;

public class NumberFour {

	public static void main(String[] args) {
		String word = "информатика";
		String newWord = "";
		char[] symbols = new char[4];
		word.getChars(7, 8, symbols, 0);
		newWord = transferWordFromArrayToString(symbols, newWord);
		symbols = clearingArray(symbols);
		word.getChars(3, 5, symbols, 0);
		newWord = transferWordFromArrayToString(symbols, newWord);
		symbols = clearingArray(symbols);
		word.getChars(7, 8, symbols, 0);
		newWord = transferWordFromArrayToString(symbols, newWord);
		System.out.println(newWord);
	}

	private static String transferWordFromArrayToString(char[] symbols, String newWord) {
		for (int i = 0; i < symbols.length; i++) {
			if (symbols[i] != '\0') {
				newWord += symbols[i];
			}
		}
		return newWord;
	}

	private static char[] clearingArray(char[] symbols) {
		for (int i = 0; i < symbols.length; i++) {
			symbols[i] = '\0';
		}
		return symbols;
	}
}