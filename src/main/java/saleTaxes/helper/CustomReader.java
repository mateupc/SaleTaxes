package saleTaxes.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomReader {
	
	public static List<String> readLines(Scanner source) {
	    String word = null;
	    List<String> words = new ArrayList<String>();
	    while (!(word = source.nextLine()).isEmpty()) {
	        words.add(word);
	    }
	    return words;
	}
	
	public static List<String> readLines(Path path) throws IOException{
		Stream<String> lines = Files.lines(path);
	    List<String> data = lines.collect(Collectors.toList());
	    lines.close();
	    return data;
	}
}
