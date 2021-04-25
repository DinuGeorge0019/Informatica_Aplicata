package shape.implementation;

import java.util.Scanner;

import shape.abstractions.*;

public class Point implements Shape{

	public int x;
	public int y;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int getId() {
		return 0;
	}
	
	@Override
	public void draw() {
		System.out.println("Drawing Point at : (" +x+"," + y + ")" );
	}
	
	@SuppressWarnings("resource")
	@Override
	public void modifyShape()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("New x : ");
		this.x = scanner.nextInt();
		System.out.println("New y : ");
		this.y = scanner.nextInt();
	}
	
	
}
