package fileioplugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import iowithplugins.abstractions.IInputDevice;

public class FileInputDevice implements IInputDevice{

	@Override
	public String ReadString() {

		String fileData = "";
		Scanner fileScanner = null;
		
		try {
			fileScanner = new Scanner(new File("input.txt"));
			
			while(fileScanner.hasNextLine())
			{
				fileData += fileScanner.nextLine();
				fileData += "\n";
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		finally {
			
			try {
				if(fileScanner != null)
				{
					fileScanner.close();
				}
				
			} catch (Exception e) {
				System.out.println("Can't close file");
			}
		}
		
		return fileData;

	}

}
