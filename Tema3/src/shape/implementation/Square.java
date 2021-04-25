package shape.implementation;

import java.util.Scanner;

import shape.abstractions.Shape;

public class Square implements Shape{

	private int sideLenght;
	private int id;

	
	public Square(int sideLenght, int id) {
		this.sideLenght = sideLenght;
		this.id = id;
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void draw() {
		System.out.println("Drawing Square, side lenght : " + sideLenght);
	}
	
	
	@SuppressWarnings("resource")
	@Override
	public void modifyShape()
	{
		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("Choose option :");
			System.out.println("1. Change side lenght");
			System.out.println("2. Change id");
			System.out.println("3. Exit");
			int option = scanner.nextInt();
			
			switch (option) {
				case 1: {
					System.out.println("New side lenght :");
					this.sideLenght = scanner.nextInt();
					break;
				}
				
				case 2:{
					System.out.println("New id :");
					this.id = scanner.nextInt();
					break;
				}
					
				case 3:{
					return;
				}
			}
		}
	}
	
}
