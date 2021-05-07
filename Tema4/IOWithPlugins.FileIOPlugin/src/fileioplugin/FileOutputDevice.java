package fileioplugin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import iowithplugins.abstractions.IOutputDevice;

public class FileOutputDevice implements IOutputDevice{
	
	@Override
	public void WriteString(String s) {
		
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(new File("output.txt"));
			writer.append(s);
			
		} catch (IOException e) {
			
			System.out.println("Can't write in file");
			e.printStackTrace();
		}
		finally {
			
			try {
				if(writer != null)
				{
					writer.close();
				}
			} catch (IOException e) {
				System.out.println("Can't close file");
				e.printStackTrace();
			}
			
		}

	}

}
