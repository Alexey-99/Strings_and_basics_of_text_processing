/* Вводится строка слов, разделенных пробелами. 
 * Найти самое длинное слово и вывести его на экран. 
 * Случай, когда самых длинных слов может быть несколько, не обрабатывать. 
 * */

package by.koroza.strings_and_basics_of_text_processing.stringbuilder;

public class NumberEight {

	public static void main(String[] args) {
		String line = "Lorem voluptates magnam tempore totam. Consectetur doloribus repellat iste asperiores?";
		System.out.println("The word with the maximum number of letters: " + maxLengthWord(line));
	}

	private static String maxLengthWord(String line) {
		char[] symbols = line.toCharArray();
		String word = "";
		String maxLengthWord = "";
		for (int i = 0; i < symbols.length; i++) {
			if (Character.isLetter(symbols[i])) {
				word += symbols[i];
			} else {
				if (maxLengthWord.length() < word.length()) {
					maxLengthWord = word;
				}
				word = "";
			}
		}
		return maxLengthWord;
	}
}