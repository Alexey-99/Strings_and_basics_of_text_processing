/*Подсчитать, сколько раз среди символов заданной строки встречается буква “а”. */

package by.koroza.strings_and_basics_of_text_processing.stringbuilder;

public class NumberFive {

	public static void main(String[] args) {
		String line = "Lorem, ipsum dolor sit amet consectetur adipisicing elit.";
		char findSymbol = 'a';
		int count = countSymbol(line, findSymbol);
		System.out.println("Character '" + findSymbol + "' occurs " + count + " times");
	}

	private static int countSymbol(String line, char findSymbol) {
		char[] symbols = line.toCharArray();
		int count = 0;
		for (int i = 0; i < symbols.length; i++) {
			if (symbols[i] == findSymbol) {
				count++;
			}
		}
		return count;
	}
}