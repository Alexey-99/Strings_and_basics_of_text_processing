/*Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем. */

package by.koroza.strings_and_basics_of_text_processing.stringbuilder;

public class NumberOne {

	public static void main(String[] args) {
		String line = " Hello.  My    name is  Alexey.     I  like  program.";
		System.out.println("Maximum number spaces in a string: " + findMaxNumberSpaces(line));
	}

	private static int findMaxNumberSpaces(String line) {
		char[] symbols = line.toCharArray();
		int countSpaces = 0;
		int maxCountSpaces = 0;
		for (int i = 0; i < symbols.length; i++) {
			if (symbols[i] == ' ') {
				countSpaces++;
			} else {
				if (maxCountSpaces < countSpaces) {
					maxCountSpaces = countSpaces;
				}
				countSpaces = 0;
			}
		}
		return maxCountSpaces;
	}
}