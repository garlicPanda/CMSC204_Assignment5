/**
 * Utility class that converts MorseCode to English using a static MorseCodeTree
 * Convert from both a string of MorseCode or a file containing MorseCode
 * @author vanessa
 *
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter
{
	static MorseCodeTree tree=new MorseCodeTree();
    public MorseCodeConverter()
    {
        tree=new MorseCodeTree();
    }
	
	/**
	 * Prints all the elements of the MorseCodeTree in LNR order
	 * Uses the toArrayList() method of MorseCodeTree to test if built correctly
	 * @return the data in the tree in the correct order separated by a space
	 */
	public static String printTree() {
		
		String output = "";
		ArrayList<String> print = tree.toArrayList();
		for(int i = 0; i < print.size(); i++) {
			output += print.get(i);
			if(i + 1 != print.size()) {
				output += " ";
			}
		}return output;
	}
	
	
	/**
	 * Converts a MorseCodeTree string into English
	 * Every letter is delimited by a '.' and every word by a '/'
	 * @param code the morse code string
	 * @return the English translation
	 */
	public static String convertToEnglish(String code) {
		 String words[] = code.split("/");
		 String output = "";
		 String letters[];
		 for(int i = 0; i < words.length; i++) {
			 words[i] = words[i].trim();
			 letters = words[i].split(" ");
			 for(int j = 0; j < letters.length; j++) {
				 output += tree.fetch(letters[j]);
			 }output += " ";
		 }return output.trim();
	}
	
	
	/**
	 * Converts a file of MorseCode into English
	 * Every letter is delimited by a '.' and every word by a '/'
	 * @param codeFile the file that contains MorseCode
	 * @return the English translation of the file
	 * @throws FileNotFoundException thrown if file is not found
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		
		while (!codeFile.exists())
			throw new FileNotFoundException("File not found");
		
		Scanner fileReader = new Scanner(codeFile);
		StringBuilder fileRead = new StringBuilder();
		
		while(fileReader.hasNextLine()) {
			fileRead.append(fileReader.nextLine()).append(" ");
		}
		
		fileReader.close();
		
		return convertToEnglish(fileRead.toString());
	}

}
