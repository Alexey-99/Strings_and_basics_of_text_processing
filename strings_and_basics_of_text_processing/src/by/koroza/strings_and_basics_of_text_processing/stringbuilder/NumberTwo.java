/*В строке вставить после каждого символа 'a' символ 'b'.*/

package by.koroza.strings_and_basics_of_text_processing.stringbuilder;

public class NumberTwo {

	public static void main(String[] args) {
		String line = "Hello. My name is Alexey. I like program.";
		System.out.println(insertingCharacter(line));
	}
	
	private static String insertingCharacter(String line) {
		char[] symbols = line.toCharArray();
		String lineNew = "";
		for (int i = 0; i < symbols.length; i++) {
			if (symbols[i] == 'a') {
				lineNew += symbols[i];
				lineNew += 'b';
			} else {
				lineNew += symbols[i];
			}
		}
		return lineNew;
	}
}