package main;

import paint.sheet.Painting;

public class Main {
	
	public static void main(String[] args) {

		PaintApp app = new PaintApp(new Painting("MainPainting"));
		app.load();
		app.execute();
		
	}
}
