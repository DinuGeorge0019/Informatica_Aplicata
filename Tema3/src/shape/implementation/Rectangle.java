package shape.implementation;

import java.util.Scanner;

import shape.abstractions.Shape;

public class Rectangle implements Shape{

	private int width;
	private int height;
	private int id;

	
	public Rectangle(int width, int height, int id) {
		this.width = width;
		this.height = height;
		this.id = id;
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void draw() {
		System.out.println("Drawing Rectangle, width : " + width + ", height : " + height);
	}
	
	@SuppressWarnings("resource")
	@Override
	public void modifyShape()
	{
		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("Choose option :");
			System.out.println("1. Change width");
			System.out.println("2. Change height");
			System.out.println("3. Change id");
			System.out.println("4. Exit");
			int option = scanner.nextInt();
			
			switch (option) {
				case 1: {
					System.out.println("New width :");
					this.width = scanner.nextInt();
					break;
				}
				
				case 2:{
					System.out.println("New height :");
					this.height = scanner.nextInt();
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
