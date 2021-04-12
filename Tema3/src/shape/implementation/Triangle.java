package shape.implementation;

import shape.abstractions.Shape;

public class Triangle implements Shape{

	private int sideLenght;
	private Point p1;
	private Point p2;
	private Point p3;
	private int idx;

	
	public Triangle(int sideLenght, Point p1, Point p2, Point p3, int idx) {
		this.p1 =p1;
		this.p2 =p2;
		this.p3 = p3;
		this.sideLenght = sideLenght;
		this.idx = idx;
	}
	
	public int getIdx() {
		return idx;
	}
	
	public void draw() {
		System.out.println("Drawing Triangle, side lenght : " + sideLenght +
				" at : (" +p1.x +", " +p1.y+"), (" +p2.x +", " +p2.y +"), (" +p3.x +", " +p3.y +")");
	}
	
}
