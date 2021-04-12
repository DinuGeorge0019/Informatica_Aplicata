package shape.implementation;

import shape.abstractions.Shape;

public class Square implements Shape{

	private int sideLenght;
	private int idx;

	
	public Square(int sideLenght, int idx) {
		this.sideLenght = sideLenght;
		this.idx = idx;
	}
	
	public int getIdx() {
		return idx;
	}
	
	public void draw() {
		System.out.println("Drawing Square, side lenght : " + sideLenght);
	}
	
}
