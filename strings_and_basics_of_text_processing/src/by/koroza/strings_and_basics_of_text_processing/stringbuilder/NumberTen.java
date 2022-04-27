/* Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным знаком. 
 * Определить количество предложений в строке X. 
 */

package by.koroza.strings_and_basics_of_text_processing.stringbuilder;

public class NumberTen {

	public static void main(String[] args) {
		String line = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. "
				+ "Odio aut, harum, veniam, nemo nihil voluptatem consequuntur magnam "
				+ "adipisci quas cupiditate sint qui deserunt exercitationem eius labore optio minus atque? Hic.";
		int numberSentences = countSentences(line);
		System.out.println("In the line is " + numberSentences + " sentences.");
	}

	private static int countSentences(String line) {
		char[] symbols = line.toCharArray();
		int countSentences = 0;
		for (int i = 0; i < symbols.length; i++) {
			if (i < symbols.length - 1) {
				if ((symbols[i] == '.' && Character.isWhitespace(symbols[i + 1]))
						|| (symbols[i] == '!' && Character.isWhitespace(symbols[i + 1]))
						|| (symbols[i] == '?' && Character.isWhitespace(symbols[i + 1]))) {
					countSentences++;
				}
			} else if (i == symbols.length - 1) {
				countSentences++;
			}
		}
		return countSentences;
	}
}