/*Замените в строке все вхождения 'word' на 'letter'. */

package by.koroza.strings_and_basics_of_text_processing.character;

public class NumberTwo {

	public static void main(String[] args) {
		String stringLine = "word Привет, word привет word";
		String word = "word";
		String changeWord = "letter";
		String newStringLine = changeWords(stringLine, word, changeWord);
		System.out.println(newStringLine);
	}

	private static String changeWords(String stringLine, String word, String changeWord) {
		String newStringLine = "";
		char[] symbols = stringLine.toCharArray();
		int wordlength = countSymbols(word);
		char[] symbolsWord = word.toCharArray();
		for (int i = 0; i < symbols.length; i++) {
			if (i <= symbols.length - wordlength) {
				String combinationLetters = combinationLettersWord(symbols, wordlength, i);
				if (word.equals(combinationLetters)) {
					newStringLine += changeWord;
					i += wordlength - 1;
				} else {
					newStringLine += symbols[i];
				}
			} else if ((i > symbols.length - wordlength) && (symbols[symbols.length - wordlength] != symbolsWord[0])) {
				newStringLine += symbols[i];
			}
		}
		return newStringLine;
	}

	private static int countSymbols(String line) {
		char[] symbols = line.toCharArray();
		return symbols.length;
	}

	private static String combinationLettersWord(char[] symbols, int wordlength, int startPoint) {
		String combinationLetters = "";
		for (int i = startPoint; i < startPoint + wordlength; i++) {
			combinationLetters += symbols[i];
		}
		return combinationLetters;
	}
}