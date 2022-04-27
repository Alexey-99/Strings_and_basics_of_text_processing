/* Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. 
 * Например, если было введено "abc cde def", то должно быть выведено "abcdef". */

package by.koroza.strings_and_basics_of_text_processing.stringbuilder;

public class NumberSeven {

	public static void main(String[] args) {
		String line = "Lorem ipssum doolor sit amet consectetur adipisicing elitt";
		line = removeRepeatedCharactersAndSpaces(line);
		System.out.println(line);
	}

	private static String removeRepeatedCharactersAndSpaces(String line) {
		String newLine = removeSpaces(line);
		newLine = removeRepeatedCharacters(newLine);
		return newLine;
	}

	private static String removeSpaces(String line) {
		char[] symbols = line.toCharArray();
		String newLine = "";
		for (int i = 0; i < symbols.length; i++) {
			if (!Character.isSpaceChar(symbols[i])) {
				newLine += symbols[i];
			}
		}
		return newLine;
	}

	private static String removeRepeatedCharacters(String line) {
		char[] symbols = line.toCharArray();
		String newLine = "";
		for (int i = 0; i < symbols.length; i++) {
			char symbolI = '\0';
			char symbolIPlusOne = '\0';
			if (i < symbols.length - 1) {
				if (Character.isUpperCase(symbols[i])) {
					symbolI = Character.toLowerCase(symbols[i]);
				} else {
					symbolI = symbols[i];
				}
				if (Character.isUpperCase(symbols[i + 1])) {
					symbolIPlusOne = Character.toLowerCase(symbols[i + 1]);
				} else {
					symbolIPlusOne = symbols[i + 1];
				}
			}
			if (i < symbols.length - 1 && symbolI != symbolIPlusOne) {
				newLine += symbols[i];
			} else if (i == symbols.length - 1) {
				newLine += symbols[i];
			}
		}
		return newLine;
	}
}