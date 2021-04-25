package fileioplugin;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import iowithplugins.abstractions.IInputDevice;

public class FileInputDevice implements IInputDevice{

	@Override
	public String ReadString() {
		
		
		String inputData;
		
		File inputFile = new File("input.txt");
		
		try {
			Scanner scanner = new Scanner(inputFile);
			inputData = scanner.next();
			scanner.close();
			
		} catch (IOException e) {
			
			System.out.println("Can't read data from" + inputFile.toString() + "file");
			e.printStackTrace();
			return "";
		}
		
		
		return inputData;
	}

}
