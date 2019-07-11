package saleTaxes.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemInputReader {
	
	public static List<String> readWords(Scanner source) {
	    String word = null;
	    List<String> words = new ArrayList<String>();
	    while (!(word = source.nextLine()).isEmpty()) {
	        words.add(word);
	    }
	    return words;
	}
}
