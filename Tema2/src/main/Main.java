package main;

import students_grup_menu.implementation.GrupMenu;

public class Main {

	public static void main(String[] args)
	{
		GrupMenu grupMenu = new GrupMenu();
		grupMenu.load();
		grupMenu.execute();
	}
	
}
