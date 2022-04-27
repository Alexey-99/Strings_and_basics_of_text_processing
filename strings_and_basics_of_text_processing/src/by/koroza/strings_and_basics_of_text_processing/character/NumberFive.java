/*Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы. 
 * Крайние пробелы в строке удалить. */

package by.koroza.strings_and_basics_of_text_processing.character;

public class NumberFive {

	public static void main(String[] args) {
		String line = "    55   I  11.   53 like   12.00.     1 Java   19, language   20. 2.2   ";
		line = removingSpaces(line);
		System.out.println("The String without spaces: " + line);
	}

	private static String removingSpaces(String line) {
		line = removeSpacesBeginning(line);
		line = removeSpacesEnd(line);
		line = removeSpacesMiddle(line);
		return line;
	}

	private static String removeSpacesBeginning(String line) {
		char[] symbols = line.toCharArray();
		String newLine = "";
		if (symbols[0] == ' ') {
			boolean flagWhile = true;
			int index = 0;
			while (flagWhile == true && index < symbols.length) {
				if (symbols[index] == ' ') {
					flagWhile = true;
				} else {
					flagWhile = false;
					for (int i = index; i < symbols.length; i++) {
						newLine += symbols[i];
					}
				}
				index++;
			}
		}
		return newLine;
	}

	private static String removeSpacesEnd(String line) {
		char[] symbols = line.toCharArray();
		String newLine = "";
		if (symbols[symbols.length - 1] == ' ') {
			boolean flagWhile = true;
			int index = symbols.length - 1;
			while (flagWhile == true && index >= 0) {
				if (symbols[index] == ' ') {
					flagWhile = true;
				} else {
					flagWhile = false;
					for (int i = 0; i <= symbols.length - (symbols.length - index); i++) {
						newLine += symbols[i];
					}
				}
				index--;
			}
		}
		return newLine;
	}

	private static String removeSpacesMiddle(String line) {
		char[] symbols = line.toCharArray();
		String newLine = "";
		for (int i = 0; i < symbols.length; i++) {
			if (symbols[i] == ' ') {
				if (symbols[i + 1] != ' ') {
					newLine += symbols[i];
				}
			} else {
				newLine += symbols[i];
			}
		}
		return newLine;
	}
}