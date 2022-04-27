/* Из заданной строки получить новую, повторив каждый символ дважды. */

package by.koroza.strings_and_basics_of_text_processing.stringbuilder;

public class NumberSix {

	public static void main(String[] args) {
		String line = "Lorem, ipsum dolor";
		String newLine = createNewSting(line);
		System.out.println(newLine);
	}

	private static String createNewSting(String line) {
		char[] symbols = line.toCharArray();
		String newLine = "";
		for (int i = 0; i < symbols.length; i++) {
			newLine += symbols[i];
			newLine += symbols[i];
		}
		return newLine;
	}
}