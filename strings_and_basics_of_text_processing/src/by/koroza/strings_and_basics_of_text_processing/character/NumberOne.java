/* Дан массив названий переменных в camelCase. Преобразовать названия в snake_case. */

package by.koroza.strings_and_basics_of_text_processing.character;

public class NumberOne {

	public static void main(String[] args) {
		String[] camelCase = { "getChars", "equalsIgnoreCase", "toLowerCase", "toUpperCase", "toCharArray", "charAt" };
		String[] snakeCase = toSnakeCase(camelCase);
		System.out.println(String.join(", ", camelCase));
		System.out.println(String.join(", ", snakeCase));
	}

	private static String[] toSnakeCase(String[] camelCase) {
		String[] snakeCase = new String[camelCase.length];
		for (int i = 0; i < camelCase.length; i++) {
			String elementSnakeCase = "";
			char[] symbolArray = camelCase[i].toCharArray();
			for (int j = 0; j < symbolArray.length; j++) {
				if (Character.isLowerCase(symbolArray[j])) {
					elementSnakeCase += symbolArray[j];
				} else {
					elementSnakeCase += "_" + Character.toLowerCase(symbolArray[j]);
				}
			}
			snakeCase[i] = elementSnakeCase;
		}
		return snakeCase;
	}
}