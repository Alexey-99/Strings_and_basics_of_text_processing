package by.koroza.strings_and_basics_of_text_processing.patternmatcher.numberone.finishchar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinishCharSentence {
	private final static String DEVISION_ON_PARAGRAPHS = "\\s{4}";
	private final static String FIND_FINISH_CHAR_ON_SENTENCES = "([.|!|?]\\s)|[.|!|?]";
	private final static String DEVISION_FINISH_CHAR_ON_SENTENCE = "\\s";

	public static String[][] saveFinishCharsSentenceWithSort(String[] arrayParagraphs) {
		String finishChars = findFinishCharsSentence(arrayParagraphs);
		String[] arrayFinishChars = devisionFinishCharsOnParagraph(finishChars);
		String[][] matrixFinishChars = devisionFinishCharsOnSentence(arrayFinishChars);
		sortFinishChars(matrixFinishChars);
		return matrixFinishChars;
	}
	
	public static String[][] saveFinishCharsSentenceWithoutSort(String[] arrayParagraphs) {
		String finishChars = findFinishCharsSentence(arrayParagraphs);
		String[] arrayFinishChars = devisionFinishCharsOnParagraph(finishChars);
		String[][] matrixFinishChars = devisionFinishCharsOnSentence(arrayFinishChars);
		return matrixFinishChars;
	}

	public static String saveFinishCharsSentence(String oldSentence) {
		String finishChars = findFinishCharsSentence(oldSentence);
		return finishChars;
	}

	private static String findFinishCharsSentence(String[] arrayParagraphs) {
		String finishChars = "";
		for (int i = 0; i < arrayParagraphs.length; i++) {
			Pattern p = Pattern.compile(FIND_FINISH_CHAR_ON_SENTENCES);
			Matcher m = p.matcher(arrayParagraphs[i]);
			while (m.find()) {
				finishChars += m.group();
			}
			if (i < arrayParagraphs.length - 1) {
				finishChars += "    ";
			}
		}
		return finishChars;
	}

	private static String findFinishCharsSentence(String sentence) {
		String finishChars = "";
		Pattern p = Pattern.compile(FIND_FINISH_CHAR_ON_SENTENCES);
		Matcher m = p.matcher(sentence);
		while (m.find()) {
			finishChars += m.group();
		}

		return finishChars;
	}

	private static String[] devisionFinishCharsOnParagraph(String finishChars) {
		String[] arrayFinishChars = finishChars.split(DEVISION_ON_PARAGRAPHS);
		return arrayFinishChars;
	}

	private static String[][] devisionFinishCharsOnSentence(String[] arrayFinishChars) {
		String[][] matrixFinishChars = new String[arrayFinishChars.length][];
		for (int i = 0; i < arrayFinishChars.length; i++) {
			matrixFinishChars[i] = arrayFinishChars[i].split(DEVISION_FINISH_CHAR_ON_SENTENCE);
		}
		return matrixFinishChars;
	}

	private static void sortFinishChars(String[][] matrixFinishChars) {
		for (int i = 0; i < matrixFinishChars.length - 1; i++) {
			if (matrixFinishChars[i].length < matrixFinishChars[i + 1].length) {
				String[] arrayTmp = matrixFinishChars[i];
				matrixFinishChars[i] = matrixFinishChars[i + 1];
				matrixFinishChars[i + 1] = arrayTmp;
			}
		}
	}
}