import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class

public class writeFile {
	
	private String fileContents;
	private String filepath;

	public writeFile(String fileContents, String filepath) {
		this.fileContents = fileContents;
		this.filepath = filepath;
	}

	public String getFileContents() {
		return fileContents;	
	}

	public String getFilePath() {
		return filepath;
	}

       	public void write() {
    	
		try {
			// use FileWriter

			String filepath = getFilePath();

      			FileWriter myWriter = new FileWriter(filepath);
			
			// write the file contents

			String fileContents = getFileContents();

      			myWriter.write(fileContents);

     			myWriter.close();  // must close manually

      			System.out.println("Successfully wrote to the file.")
				;
    		} catch (IOException e) {
      			System.out.println("An error occurred.");
      			e.printStackTrace();
    		}
  	}
}
