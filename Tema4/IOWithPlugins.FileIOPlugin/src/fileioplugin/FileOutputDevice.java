package fileioplugin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import iowithplugins.abstractions.IOutputDevice;

public class FileOutputDevice implements IOutputDevice{
	
	@Override
	public void WriteString(String s) {
		
		File outputFile = new File("output.txt");
		
		try {
			FileWriter writer = new FileWriter(outputFile);
			writer.write(s);
			writer.close();
			
		} catch (IOException e) {
			
			System.out.println("Can't write in" + outputFile.toString() + "file");
			e.printStackTrace();
			return;
		}
	}

}
