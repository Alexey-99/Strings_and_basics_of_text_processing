package by.koroza.strings_and_basics_of_text_processing.patternmatcher.numberone.sorting;

import by.koroza.strings_and_basics_of_text_processing.patternmatcher.numberone.finishchar.FinishCharSentence;
import by.koroza.strings_and_basics_of_text_processing.patternmatcher.numberone.validation.Validation;

public class SortParagraphsByNumberSentences {
	private final static String DEVISION_ON_PARAGRAPHS = "\\s{4}";
	private final static String DEVISION_ON_SENTENCE = "([.|!|?]\\s)|[.|!|?]";

	public static String[][] sortParagraphsByNumberSentences(String text) {
		String[] arrayParagraphs = divisionTextOnParagraphs(text);
		String[][] matrixParagraphsWithSentences = new String[arrayParagraphs.length][];
		for (int i = 0; i < arrayParagraphs.length; i++) {
			matrixParagraphsWithSentences[i] = divisionParagraphOnSentence(arrayParagraphs[i]);
		}
		matrixParagraphsWithSentences = Validation.validationOnNullMatrix(matrixParagraphsWithSentences);
		sortParagraphs(matrixParagraphsWithSentences);
		String[][] matrixFinishChars = FinishCharSentence.saveFinishCharsSentenceWithSort(arrayParagraphs);
		combinationSentencesAndSymbols(matrixParagraphsWithSentences, matrixFinishChars);
		return matrixParagraphsWithSentences;
	}

	public static String[][] divisionTextOnSentence(String text) {
		String[] arrayParagraphs = divisionTextOnParagraphs(text);
		String[][] matrixParagraphsWithSentences = new String[arrayParagraphs.length][];
		for (int i = 0; i < arrayParagraphs.length; i++) {
			matrixParagraphsWithSentences[i] = divisionParagraphOnSentence(arrayParagraphs[i]);
		}
		matrixParagraphsWithSentences = Validation.validationOnNullMatrix(matrixParagraphsWithSentences);
		String[][] matrixFinishChars = FinishCharSentence.saveFinishCharsSentenceWithoutSort(arrayParagraphs);
		combinationSentencesAndSymbols(matrixParagraphsWithSentences, matrixFinishChars);
		return matrixParagraphsWithSentences;
	}

	private static String[] divisionTextOnParagraphs(String text) {
		String[] arrayParagraphs = text.split(DEVISION_ON_PARAGRAPHS);
		arrayParagraphs = Validation.validationOnNullArray(arrayParagraphs);
		return arrayParagraphs;
	}

	private static String[] divisionParagraphOnSentence(String paragraph) {
		String[] arraySentences = paragraph.split(DEVISION_ON_SENTENCE);
		arraySentences = Validation.validationOnNullArray(arraySentences);
		return arraySentences;
	}

	private static void sortParagraphs(String[][] matrixSentences) {
		for (int i = 0; i < matrixSentences.length - 1; i++) {
			if (matrixSentences[i].length < matrixSentences[i + 1].length) {
				String[] arrayTmp = matrixSentences[i];
				matrixSentences[i] = matrixSentences[i + 1];
				matrixSentences[i + 1] = arrayTmp;
			}
		}
	}

	private static void combinationSentencesAndSymbols(String[][] matrixParagraphsWithSentences,
			String[][] matrixFinishChars) {
		for (int i = 0; i < matrixParagraphsWithSentences.length; i++) {
			for (int j = 0; j < matrixParagraphsWithSentences[i].length; j++) {
				matrixParagraphsWithSentences[i][j] += matrixFinishChars[i][j];
				matrixParagraphsWithSentences[i][j] = matrixParagraphsWithSentences[i][j].trim();
			}
		}
	}
}