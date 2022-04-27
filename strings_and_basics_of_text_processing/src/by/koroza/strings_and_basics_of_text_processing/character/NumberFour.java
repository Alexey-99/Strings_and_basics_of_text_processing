/*В строке найти количество чисел.*/

package by.koroza.strings_and_basics_of_text_processing.character;

public class NumberFour {

	public static void main(String[] args) {
		String line = "55 Используйте 11. 53 вместо 12.00. 1 Пишите 19, а не 20. 2.2";
		System.out.println("В стороке (" + line + ") находиться " + countNumbers(line) + " чисел");
	}

	private static int countNumbers(String line) {
		char[] symbols = line.toCharArray();
		int indexLastElement = symbols.length - 1;
		int indexBeforeLastElement = symbols.length - 2;
		int countNumbers = 0;
		for (int i = 0; i < symbols.length - 1; i++) {
			if (Character.isDigit(symbols[i]) || symbols[i] == '.') {
				if (((!Character.isDigit(symbols[i + 1]) && symbols[i + 1] != '.'))
						|| (i == indexBeforeLastElement && Character.isDigit(symbols[indexLastElement]))) {
					countNumbers++;
				}
			}
		}
		return countNumbers;
	}
}