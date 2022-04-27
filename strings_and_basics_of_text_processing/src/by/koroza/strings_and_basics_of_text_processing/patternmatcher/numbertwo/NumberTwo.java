/* Дана строка, содержащая следующий текст (xml-документ):  
*  <notes>    
*     <note id = "1">        
*        <to>Вася</to>        
*           <from>Света</from>        
*           <heading>Напоминание</heading>        
*           <body>Позвони мне завтра!</body>    
*     </note>    
*     <note id = "2">        
*        <to>Петя</to>        
*           <from>Маша</from>        
*           <heading>Важное напоминание</heading>        
*           <body/>    
*     </note> 
*  </notes>  
*  Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа 
*  и его тип (открывающий тег, закрывающий тег, содержимое тега, тег без тела). 
*  Пользоваться готовыми парсерами XML для решения данной задачи нельзя.
*/

package by.koroza.strings_and_basics_of_text_processing.patternmatcher.numbertwo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberTwo {
	final static String VALIDATION_ON_EMPTY_LINE = "\\w+";
	final static String OPENING_TAG = "^<[a-z]+>";
	final static String CLOSING_TAG = "^</\\w+>";
	final static String EMPTY_TAG = "<\\w+\\s+/>";
	final static String CONTENT_TAG = "(<\\w+>)(.+)(</\\w+>)";
	final static String ATTRIBUTE_TAG = "(<\\w+\\s+)(\\w+)([\\s=\\s\"]+)(.+)(\">)";

	public static void main(String[] args) throws IOException {
		File file = new File("resources/Content.xml");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		try {
			String line = reader.readLine();
			while (line != null) {
				boolean flagValidation = validationOnEmptyLine(line);
				if (flagValidation == true) {
					System.out.println(line.trim());
					analyticXML(line.trim());
					System.out.println();
				}
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		reader.close();
	}

	private static boolean validationOnEmptyLine(String line) {
		Pattern pValidation = Pattern.compile(VALIDATION_ON_EMPTY_LINE);
		Matcher mValidation = pValidation.matcher(line);
		boolean look = mValidation.lookingAt();
		boolean find = mValidation.find();
		boolean flag = false;
		if (find == true || look == true) {
			flag = true;
		}
		return flag;
	}

	private static void analyticXML(String line) {
		openingTag(line);
		closingTag(line);
		emptyTag(line);
		contentTag(line);
		attributeTag(line);
	}

	private static void openingTag(String line) {
		Pattern pOpeningTag = Pattern.compile(OPENING_TAG);
		Matcher mOpeningTag = pOpeningTag.matcher(line);
		if (mOpeningTag.matches()) {
			System.out.println(mOpeningTag.group() + " - opening tag");
		}
	}

	private static void closingTag(String line) {
		Pattern pClosingTag = Pattern.compile(CLOSING_TAG);
		Matcher mClosingTag = pClosingTag.matcher(line);
		if (mClosingTag.matches()) {
			System.out.println(mClosingTag.group() + " - closing tag");
		}
	}

	private static void emptyTag(String line) {
		Pattern pEmptyTag = Pattern.compile(EMPTY_TAG);
		Matcher mEmptyTag = pEmptyTag.matcher(line);
		if (mEmptyTag.matches()) {
			System.out.println(mEmptyTag.group() + " - empty tag");
		}
	}

	private static void contentTag(String line) {
		StringBuilder build = new StringBuilder();
		Pattern pContentTag = Pattern.compile(CONTENT_TAG);
		Matcher mContentTag = pContentTag.matcher(line);
		if (mContentTag.find()) {
			build.append(mContentTag.group(1)).append(" - opening tag, ");
			build.append(mContentTag.group(2)).append(" - tag content, ");
			build.append(mContentTag.group(3)).append(" - closing tag");
			System.out.println(build);
		}
	}

	private static void attributeTag(String line) {
		StringBuilder build = new StringBuilder();
		Pattern pAttributeTag = Pattern.compile(ATTRIBUTE_TAG);
		Matcher mAttributeTag = pAttributeTag.matcher(line);
		if (mAttributeTag.find()) {
			build.append(mAttributeTag.group(0)).append(" - opening tag with attribute: ");
			build.append(mAttributeTag.group(2)).append(" - name attribute, ");
			build.append(mAttributeTag.group(4)).append(" - attribute value");
			System.out.println(build);
		}
	}
}