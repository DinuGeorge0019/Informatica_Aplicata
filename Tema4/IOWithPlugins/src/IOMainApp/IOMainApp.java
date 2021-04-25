package IOMainApp;

import java.util.Scanner;

import iowithplugins.abstractions.*;

public class IOMainApp {

	public static void main(String[] args) {
	
		
		PluginsManager manager = new PluginsManager();
		try
		{
			manager.loadPlugins("/plugins");
		}
		catch(Exception e)
		{
			System.out.println("Modulele nu pot fi incarcate. " + e.getMessage());
		}
		
		if (manager.getPluginsList().size() > 0)
		{
			IIOPlugin selectedPlugin = null;
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Select plugin :");
			System.out.println("1. FileIOPlugin");
			System.out.println("2. StandardIOPlugin");
			int option = scanner.nextInt();
			switch (option) {
				case 1:
				{
					selectedPlugin = manager.getPluginsList().get(0);
					break;
				}
				case 2:
				{
					selectedPlugin = manager.getPluginsList().get(1);
					break;
				}
				default:
					break;
			}			
			
			IInputDevice inputDevice = selectedPlugin.getInputDevice();
			IOutputDevice outputDevice = selectedPlugin.getOutputDevice();;
			
			String readData = inputDevice.ReadString();
			outputDevice.WriteString(readData);
			
			scanner.close();
		}
		else
		{
			System.out.println("Nu exista module compatibile");
		}
	}

}
