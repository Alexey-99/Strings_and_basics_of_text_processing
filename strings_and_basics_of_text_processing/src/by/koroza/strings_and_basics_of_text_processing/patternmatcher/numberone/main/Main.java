/* Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных операции: 
 * отсортировать абзацы по количеству предложений; 
 * в каждом предложении отсортировать слова по длине; 
 * отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, 
 * а в случае равенства – по алфавиту.  
 */

package by.koroza.strings_and_basics_of_text_processing.patternmatcher.numberone.main;

import java.util.Scanner;

import by.koroza.strings_and_basics_of_text_processing.patternmatcher.numberone.sorting.SortLexemeInSentence;
import by.koroza.strings_and_basics_of_text_processing.patternmatcher.numberone.sorting.SortParagraphsByNumberSentences;
import by.koroza.strings_and_basics_of_text_processing.patternmatcher.numberone.sorting.SortWordInSentence;
import by.koroza.strings_and_basics_of_text_processing.patternmatcher.numberone.validation.Validation;

public class Main {
	final static String OPERATION_SORT_PARAGRAPHS = "If you want to sort paragraphs by number of sentences? Enter '1'";
	final static String OPERATION_SORT_WORDS = "If you want to sort the words in each sentence by length? Enter '2'";
	final static String OPERATION_SORT_LEXENES = "If you want to sort the tokens in a sentence in descending order by the number of occurrences of a given character, and in case of equality, alphabetically? Enter '3'";

	public static void main(String[] args) {
		String text = """
				   Lorem ipsum dolor sit amet consectetur adipisicing elit... Deserunt provident adipisci incidunt illum laboriosam voluptatem cupiditate possimus eos, iste nulla. Quidem ullam sint aut impedit officia natus in quis ex reiciendis ducimus, perspiciatis quae, asperiores ipsa repellat. Rerum culpa expedita, fugiat tenetur, vel alias laudantium mollitia sint veritatis minus nisi.
				   Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sit, minima dicta ipsum esse voluptates veritatis non a itaque inventore adipisci cum doloremque est praesentium cumque quaerat voluptate quam eligendi reprehenderit magnam architecto ea laborum ex! Debitis porro, sit veritatis voluptatem in quo molestiae mollitia odit facere voluptates corrupti explicabo animi doloribus eveniet sint provident numquam autem nisi totam cumque consequatur? Quidem labore magnam, non deleniti deserunt molestias amet ullam excepturi! Laudantium quia itaque eius? Non omnis quas sunt, ducimus hic earum tenetur a illum et sequi saepe, atque ipsum libero, distinctio cupiditate ad modi corporis rerum reiciendis. Explicabo, dolores? Maxime!
				   Lorem ipsum, dolor sit amet consectetur adipisicing elit. Labore, harum quo. Expedita et quos quia debitis eum sapiente accusamus unde voluptates soluta perferendis, minus ipsum eaque aperiam. Exercitationem, soluta optio.
				""";
		operationSelection(text);
	}

	private static void operationSelection(String text) {
		String numberOperation = enterOperationNumber();
		selectOperationByNumber(numberOperation, text);
	}

	@SuppressWarnings("resource")
	private static String enterOperationNumber() {
		Scanner scan = new Scanner(System.in);
		String numberOperation = "";
		boolean correct = true;
		do {
			System.out.println(OPERATION_SORT_PARAGRAPHS);
			System.out.println(OPERATION_SORT_WORDS);
			System.out.println(OPERATION_SORT_LEXENES);
			numberOperation = scan.nextLine();
			correct = Validation.validationNumberOperation(numberOperation);
		} while (correct == false);
		return numberOperation;
	}

	private static void selectOperationByNumber(String numberOperation, String text) {
		switch (numberOperation) {
		case "1":
			sortParagraphs(text);
			break;
		case "2":
			sortWords(text);
			break;
		case "3":
			sortLexemes(text);
			break;
		}
	}

	private static void printParagraphs(String[][] matrixParagraphsWithSentences) {
		for (int i = 0; i < matrixParagraphsWithSentences.length; i++) {
			System.out.print("    ");
			for (int j = 0; j < matrixParagraphsWithSentences[i].length; j++) {
				System.out.print(matrixParagraphsWithSentences[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void sortParagraphs(String text) {
		String[][] matrixParagraphsWithSentences = SortParagraphsByNumberSentences
				.sortParagraphsByNumberSentences(text);
		printParagraphs(matrixParagraphsWithSentences);
	}

	private static void sortWords(String text) {
		String[][] matrixParagraphsWithSentences = SortParagraphsByNumberSentences.divisionTextOnSentence(text);
		SortWordInSentence.sortWordsInSentences(matrixParagraphsWithSentences);
		printParagraphs(matrixParagraphsWithSentences);
	}

	private static void sortLexemes(String text) {
		String[][] matrixParagraphsWithSentences = SortParagraphsByNumberSentences.divisionTextOnSentence(text);
		SortLexemeInSentence.sortLexemeInSentence(matrixParagraphsWithSentences);
		printParagraphs(matrixParagraphsWithSentences);
	}
}