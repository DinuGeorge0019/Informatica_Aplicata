package shape.implementation;

import shape.abstractions.Shape;

public class Rectangle implements Shape{

	private int width;
	private int height;
	private int idx;

	
	public Rectangle(int width, int height, int idx) {
		this.width = width;
		this.height = height;
		this.idx = idx;
	}
	
	public int getIdx() {
		return idx;
	}
	
	public void draw() {
		System.out.println("Drawing Rectangle, width : " + width + ", height : " + height);
	}
	
}
