/* Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. 
 * Учитывать только английские буквы. */

package by.koroza.strings_and_basics_of_text_processing.stringbuilder;

public class NumberNine {

	public static void main(String[] args) {  
		String line = "Lorem voluptates привет magnam мир tempore totam.";
		countEnglishLettersAndPrintResult(line);
	}

	private static void countEnglishLettersAndPrintResult(String line) {
		int minCodeLetterisLowerCaseInTableISCII = 65;
		int maxCodeLetterisLowerCaseInTableISCII = 90;
		int minCodeLetterIsUpperCaseInTableISCII = 97;
		int maxCodeLetterIsUpperCaseInTableISCII = 122;
		int countUpperCase = 0;
		int countLowerCase = 0;
		char[] symbols = line.toCharArray();
		for (int i = 0; i < symbols.length; i++) {
			if ((symbols[i] >= minCodeLetterisLowerCaseInTableISCII
					&& symbols[i] <= maxCodeLetterisLowerCaseInTableISCII)
					|| (symbols[i] >= minCodeLetterIsUpperCaseInTableISCII
							&& symbols[i] <= maxCodeLetterIsUpperCaseInTableISCII)) {
				if (Character.isUpperCase(symbols[i])) {
					countUpperCase++;
				} else if (Character.isLowerCase(symbols[i])) {
					countLowerCase++;
				}
			}
		}
		printResult(countUpperCase, countLowerCase);
	}

	private static void printResult(int countUpperCase, int countLowerCase) {
		System.out.println("Number of English letters in lower case: " + countLowerCase);
		System.out.println("Number of English letters in upper case: " + countUpperCase);
	}
}