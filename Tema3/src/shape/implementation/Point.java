package shape.implementation;

import shape.abstractions.*;

public class Point implements Shape{

	public int x;
	public int y;
	
	public int getIdx() {
		return 0;
	}
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void draw() {
		System.out.println("Drawing Point at : (" +x+"," +y + ")" );
	}

	
	
}
