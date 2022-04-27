package by.koroza.strings_and_basics_of_text_processing.patternmatcher.numberone.validation;

import java.util.regex.Pattern;

public class Validation {
	private final static String VALIDATION_ON_ONE_DEGITS = "\\d{1}";
	private final static String VALIDATION_DEGITS_MORE_ZERO_AND_LESS_FOUR = "[1|2|3]";

	public static String[] validationOnNullArray(String[] arrayStrings) {
		int length = calculationCorrectlength(arrayStrings);
		String[] arrayCorrectStrings = new String[length];
		if (arrayStrings.length != length) {
			int indexArrayCorrectStrings = 0;
			for (int i = 0; i < arrayStrings.length; i++) {
				if ((arrayStrings[i] != null) && (arrayStrings[i] != "")) {
					arrayCorrectStrings[indexArrayCorrectStrings] = arrayStrings[i];
					indexArrayCorrectStrings++;
				}
			}
		} else {
			arrayCorrectStrings = arrayStrings;
		}
		return arrayCorrectStrings;
	}

	public static String[][] validationOnNullMatrix(String[][] matrixStrings) {
		String[][] correctMatrixStrings = new String[matrixStrings.length][];
		declarationCorrectMatrixSentences(matrixStrings, correctMatrixStrings);
		initializationCorrectMatrixSentences(matrixStrings, correctMatrixStrings);
		matrixStrings = correctMatrixStrings;
		return matrixStrings;
	}

	public static boolean validationNumberOperation(String numberOperatin) {
		boolean result = validationOnOneDigit(numberOperatin);
		if (result == true) {
			result = validationDigitMoreZeroAndLessFour(numberOperatin);
		}
		return result;
	}

	private static boolean validationOnOneDigit(String numberOperatin) {
		boolean result = Pattern.matches(VALIDATION_ON_ONE_DEGITS, numberOperatin);
		return result;
	}

	private static boolean validationDigitMoreZeroAndLessFour(String numberOperatin) {
		boolean result = Pattern.matches(VALIDATION_DEGITS_MORE_ZERO_AND_LESS_FOUR, numberOperatin);
		return result;
	}

	private static int calculationCorrectlength(String[] arrayStrings) {
		int length = 0;
		for (int i = 0; i < arrayStrings.length; i++) {
			if ((arrayStrings[i] != null) && (arrayStrings[i] != "")) {
				length++;
			}
		}
		return length;
	}

	private static void declarationCorrectMatrixSentences(String[][] matrixStrings, String[][] correctMatrixStrings) {
		for (int i = 0; i < matrixStrings.length; i++) {
			int length = calculationCorrectlength(matrixStrings[i]);
			correctMatrixStrings[i] = new String[length];
		}
	}

	private static void initializationCorrectMatrixSentences(String[][] matrixStrings,
			String[][] correctMatrixStrings) {
		for (int i = 0; i < correctMatrixStrings.length; i++) {
			for (int j = 0; j < correctMatrixStrings[i].length; j++) {
				correctMatrixStrings[i][j] = matrixStrings[i][j];
			}
		}
	}
}