import java.io.*;
import java.util.*;

public class Compiler {
	public static void main(String[] args) {
		
		// Read from Main.esp

		File myObj = new File("Main.esp");
		String fileContents = "";

		try (Scanner myReader = new Scanner(myObj)) {
      			
			while (myReader.hasNextLine()) {
        			String data = myReader.nextLine();
				fileContents += data + "\n";
      			}

    		} catch (FileNotFoundException e) {
      			System.out.println("An error occurred.");
      			e.printStackTrace();
    		} 

		// Split fileContents into an array of lines

		String[] arrayLines = fileContents.split("\n");
		
		String output = ""; // output string

		// Loop over the array of lines
		
		for (int index = 0; index < arrayLines.length; index++) {
			
			int middleIndex = (arrayLines[index].length() - 1) / 2;

			String rightLine = arrayLines[index].substring(middleIndex); // Gets the right half of each line
			
			String leftLine = arrayLines[index].substring(0, middleIndex);

			if (arrayLines[index].contains("{") == true || arrayLines[index].contains("}") == true || arrayLines[index].isEmpty() == true) {
				/* 
				 * no semicolons will be placed after curly braces or on blank lines, 
				 * so no need to strip whitespace to accomodate semicolons
				 * */

				arrayLines[index] = leftLine + rightLine; 
			}
			else {
				/*
				 * if a semicolon is needed at the end, 
				 * then strip any whitespace on the right 
				 * that the user may have accidentally put in
				*/

				arrayLines[index] = leftLine + rightLine.replaceAll("\\s+$", "");

				arrayLines[index] = arrayLines[index] + ";";
			}
			
			output += arrayLines[index];
		}
		
		Scanner input = new Scanner(System.in);

		print("What do you want to name the Java class containing your compiled code?: ");

		String outputClass = input.nextLine();
		String filepath = outputClass + ".java";
		
		writeFile fileWriter = new writeFile(output, filepath);

		fileWriter.write();
	}

	public static void print(String text) {
		System.out.println(text);
	}
}
