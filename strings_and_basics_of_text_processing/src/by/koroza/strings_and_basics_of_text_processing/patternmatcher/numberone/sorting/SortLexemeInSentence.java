package by.koroza.strings_and_basics_of_text_processing.patternmatcher.numberone.sorting;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.koroza.strings_and_basics_of_text_processing.patternmatcher.numberone.validation.Validation;

public class SortLexemeInSentence {
	private final static String DIVISION_SENTENCE_ON_LEXEME = "\\s";
	private final static String ENTER_ONE_SYMBOL_TO_SORT = "Please enter one symbol to sort the words in the sentence.";

	public static String[][] sortLexemeInSentence(String[][] matrixParagraphsWithSentences) {
		String sortСharacter = inputSortСharacter();
		for (int i = 0; i < matrixParagraphsWithSentences.length; i++) {
			for (int j = 0; j < matrixParagraphsWithSentences[i].length; j++) {
				String[] arrayLexemes = divisionSentenceOnLexemes(matrixParagraphsWithSentences[i][j]);
				arrayLexemes = Validation.validationOnNullArray(arrayLexemes);
				arrayLexemes = sortByNumberOfOccurrencesCharacter(arrayLexemes, sortСharacter);
				arrayLexemes = alphabeticalSortWithSameNumberChars(arrayLexemes, sortСharacter);
				matrixParagraphsWithSentences[i][j] = combiningWordsIntoSentence(arrayLexemes);
			}
		}
		return matrixParagraphsWithSentences;
	}

	private static String[] divisionSentenceOnLexemes(String sentences) {
		String[] arrayLexemes = sentences.split(DIVISION_SENTENCE_ON_LEXEME);
		return arrayLexemes;
	}

	private static String inputSortСharacter() {
		Scanner scan = new Scanner(System.in);
		String sortСharacter = "";
		do {
			System.out.println(ENTER_ONE_SYMBOL_TO_SORT);
			sortСharacter = scan.nextLine();
		} while (sortСharacter.length() != 1);
		scan.close();
		return sortСharacter;
	}

	private static String[] sortByNumberOfOccurrencesCharacter(String[] arrayLexemes, String sortСharacter) {
		int countRepetCharInElementI = 0;
		int countRepetCharInElementJ = 0;
		for (int i = 0; i < arrayLexemes.length; i++) {
			countRepetCharInElementI = countRepetCharInElement(arrayLexemes[i], sortСharacter);
			for (int j = i; j < arrayLexemes.length; j++) {
				countRepetCharInElementJ = countRepetCharInElement(arrayLexemes[j], sortСharacter);
				if (countRepetCharInElementI < countRepetCharInElementJ) {
					String tmp = arrayLexemes[i];
					arrayLexemes[i] = arrayLexemes[j];
					arrayLexemes[j] = tmp;
					countRepetCharInElementI = countRepetCharInElement(arrayLexemes[i], sortСharacter);

				}
			}
		}
		return arrayLexemes;
	}

	private static String[] alphabeticalSortWithSameNumberChars(String[] arrayLexemes, String sortСharacter) {
		int indexStartRepeat = 0;
		int indexFinishRepeat = 0;
		int countRepetCharInElementFirstI = 0;
		int countRepetCharInElementSecondI = 0;
		int countRepetCharInElementLessOneFirstI = 0;
		int countRepetCharInElementFirstJ = 0;
		int countRepetCharInElementSecondJ = 0;
		for (int i = 0; i < arrayLexemes.length - 1; i++) {
			countRepetCharInElementFirstI = countRepetCharInElement(arrayLexemes[i], sortСharacter);
			countRepetCharInElementSecondI = countRepetCharInElement(arrayLexemes[i + 1], sortСharacter);
			if (countRepetCharInElementFirstI == countRepetCharInElementSecondI) {
				if (i > 0) {
					countRepetCharInElementLessOneFirstI = countRepetCharInElement(arrayLexemes[i - 1], sortСharacter);
				}
				if ((i == 0) || ((i > 0) && (countRepetCharInElementFirstI != countRepetCharInElementLessOneFirstI))) {
					indexStartRepeat = i;
					boolean flag = true;
					for (int j = i; j < arrayLexemes.length && flag == true; j++) {
						if (j == arrayLexemes.length - 1) {
							countRepetCharInElementFirstJ = countRepetCharInElement(arrayLexemes[j], sortСharacter);
						} else {
							countRepetCharInElementFirstJ = countRepetCharInElement(arrayLexemes[j], sortСharacter);
							countRepetCharInElementSecondJ = countRepetCharInElement(arrayLexemes[j + 1],
									sortСharacter);
						}
						if ((j < arrayLexemes.length - 1
								&& countRepetCharInElementFirstJ != countRepetCharInElementSecondJ)
								|| (j == arrayLexemes.length - 1)) {
							indexFinishRepeat = j;
							flag = false;
							i = j;
							arrayLexemes = alphabeticalSort(arrayLexemes, indexStartRepeat, indexFinishRepeat);
						}
					}
				}
			}
		}
		return arrayLexemes;
	}

	private static int countRepetCharInElement(String element, String sortСharacter) {
		int count = 0;
		Pattern p = Pattern.compile(sortСharacter);
		Matcher m = p.matcher(element);
		while (m.find()) {
			count++;
		}
		return count;
	}

	private static String[] alphabeticalSort(String[] arrayLexemes, int indexStartRepeat, int indexFinishRepeat) {
		String[] newArrayLexemes = creadArrayWithSortingElements(arrayLexemes, indexStartRepeat, indexFinishRepeat);
		sort(newArrayLexemes);
		int index = 0;
		for (int i = indexStartRepeat; i <= indexFinishRepeat; i++) {
			arrayLexemes[i] = newArrayLexemes[index];
			index++;
		}
		return arrayLexemes;
	}

	private static String[] sort(String[] newArrayLexemes) { 
		int compare;
		for (int i = 0; i < newArrayLexemes.length; i++) {
			for (int j = i; j < newArrayLexemes.length; j++) {
				compare = newArrayLexemes[i].compareTo(newArrayLexemes[j]);
				if (compare > 0) {
					String tmp = newArrayLexemes[i];
					newArrayLexemes[i] = newArrayLexemes[j];
					newArrayLexemes[j] = tmp;
				}
			}
		}
		return newArrayLexemes;
	}

	private static String[] creadArrayWithSortingElements(String[] arrayLexemes, int indexStartRepeat,
			int indexFinishRepeat) {
		String[] newArrayLexemes = new String[indexFinishRepeat - indexStartRepeat + 1];
		int indexNewArrayLexemes = 0;
		for (int i = indexStartRepeat; i <= indexFinishRepeat; i++) {
			newArrayLexemes[indexNewArrayLexemes] = arrayLexemes[i];
			indexNewArrayLexemes++;
		}
		return newArrayLexemes;
	}

	private static String combiningWordsIntoSentence(String[] arrayLexemes) {
		String sentence = "";
		for (int i = 0; i < arrayLexemes.length; i++) {
			sentence += arrayLexemes[i];
			sentence += " ";
		}
		sentence += "   ";
		return sentence;
	}
}