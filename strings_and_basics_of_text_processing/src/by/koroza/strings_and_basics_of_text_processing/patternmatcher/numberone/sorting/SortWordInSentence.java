package by.koroza.strings_and_basics_of_text_processing.patternmatcher.numberone.sorting;

import by.koroza.strings_and_basics_of_text_processing.patternmatcher.numberone.finishchar.FinishCharSentence;
import by.koroza.strings_and_basics_of_text_processing.patternmatcher.numberone.validation.Validation;

public class SortWordInSentence {
	private final static String DEVISION_SENTENCE_ON_WORDS = "\\s|[,|.|!|?]";

	public static String[][] sortWordsInSentences(String[][] matrixParagraphsWithSentences) {
		for (int i = 0; i < matrixParagraphsWithSentences.length; i++) {
			for (int j = 0; j < matrixParagraphsWithSentences[i].length; j++) {
				String oldSentence = matrixParagraphsWithSentences[i][j];
				String[] arrayWordsFromSentence = divisionSentenceOnWords(matrixParagraphsWithSentences[i][j]);
				arrayWordsFromSentence = Validation.validationOnNullArray(arrayWordsFromSentence);
				sortingWordsInSentence(arrayWordsFromSentence);
				matrixParagraphsWithSentences[i][j] = connectWordsToSentence(arrayWordsFromSentence).trim();
				String finishChars = FinishCharSentence.saveFinishCharsSentence(oldSentence);
				matrixParagraphsWithSentences[i][j] = combinationSentencesAndSymbols(
						matrixParagraphsWithSentences[i][j], finishChars);
			}
		}
		return matrixParagraphsWithSentences;
	}

	private static String[] divisionSentenceOnWords(String sentences) {
		String[] arrayWordsFromSentence = sentences.split(DEVISION_SENTENCE_ON_WORDS);
		return arrayWordsFromSentence;
	}

	private static String[] sortingWordsInSentence(String[] arrayWordsFromSentence) {
		for (int i = 0; i < arrayWordsFromSentence.length; i++) {
			for (int j = i; j < arrayWordsFromSentence.length; j++) {
				if (arrayWordsFromSentence[i].length() < arrayWordsFromSentence[j].length()) {
					String tmp = arrayWordsFromSentence[i];
					arrayWordsFromSentence[i] = arrayWordsFromSentence[j];
					arrayWordsFromSentence[j] = tmp;
				}
			}
		}
		return arrayWordsFromSentence;
	}

	private static String connectWordsToSentence(String[] arrayWordsFromSentence) {
		String sentence = "";
		for (int i = 0; i < arrayWordsFromSentence.length; i++) {
			sentence += arrayWordsFromSentence[i];
			sentence += " ";
		}
		return sentence;
	}

	private static String combinationSentencesAndSymbols(String sortedSentence, String finishChars) {
		sortedSentence += finishChars;
		return sortedSentence;
	}
}