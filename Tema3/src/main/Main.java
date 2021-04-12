package main;

import paint.sheet.Painting;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Painting paint = new Painting("MainPaintSheet");
		paint.load();
		paint.execute();
		
	}
}
