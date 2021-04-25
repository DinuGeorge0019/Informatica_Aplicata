package shape.implementation;


import java.util.Scanner;

import shape.abstractions.Shape;

public class Circle implements Shape{

	private int radius;
	private Point centerPoint;
	private int id;
	
	public Circle(int radius, Point centerPoint, int id) {
		this.radius = radius;
		this.centerPoint = centerPoint;
		this.id = id;
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void draw()
	{
		System.out.println("Drawing circle : ");
		System.out.println("Center : ");
		centerPoint.draw();
		System.out.println("Radius : " + radius);
	}
	
	@SuppressWarnings("resource")
	@Override
	public void modifyShape()
	{
		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("Choose option :");
			System.out.println("1. Change center point");
			System.out.println("2. Change radius");
			System.out.println("3. Change id");
			System.out.println("4. Exit");
			int option = scanner.nextInt();
			
			switch (option) {
				case 1: {
					this.centerPoint.modifyShape();
					break;
				}
				
				case 2:{
					System.out.println("New radius :");
					this.radius = scanner.nextInt();
					break;
				}
				
				case 3:{
					System.out.println("New id :");
					this.id = scanner.nextInt();
					break;
				}
					
				case 4:{
					return;
				}
			}
		}
	}

	

}
