package shape.implementation;


import shape.abstractions.Shape;

public class Circle implements Shape{

	private int radius;
	private Point p;
	private int idx;
	
	public Circle(int radius, Point center, int idx) {
		this.radius = radius;
		this.p = center;
		this.idx = idx;
	}
	
	public int getIdx() {
		return idx;
	}
	
	@Override
	public void draw()
	{
		System.out.println("Drawing circle : ");
		System.out.println("Center : ");
		p.draw();
		System.out.println("Radius : " + radius);
	}
	

}
