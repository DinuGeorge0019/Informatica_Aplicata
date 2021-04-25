package shape.implementation;

import java.util.Scanner;

import shape.abstractions.Shape;

public class Triangle implements Shape{

	private int sideLenght1;
	private int sideLenght2;
	private int sideLenght3;

	private int id;

	
	public Triangle(int sideLenght1, int sideLenght2, int sideLenght3, int id) {
		this.sideLenght1 = sideLenght1;
		this.sideLenght2 = sideLenght2;
		this.sideLenght3 = sideLenght3;
		this.id = id;
	}
	

	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void draw() {
		System.out.println("Drawing Triangle, side lenght1 : " + 
				+ sideLenght1 + " side lenght2 :" + sideLenght2 +  " side lenght3 :" + sideLenght3);
	}
	
	@SuppressWarnings("resource")
	@Override
	public void modifyShape()
	{
		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("Choose option :");
			System.out.println("1. Change side lenght 1");
			System.out.println("1. Change side lenght 2");
			System.out.println("1. Change side lenght 3");
			System.out.println("2. Change id");
			System.out.println("3. Exit");
			int option = scanner.nextInt();
			
			switch (option) {
				case 1: {
					System.out.println("New side lenght 1 :");
					this.sideLenght1 = scanner.nextInt();
					break;
				}
				
				case 2: {
					System.out.println("New side lenght 2 :");
					this.sideLenght2 = scanner.nextInt();
					break;
				}
				
				case 3: {
					System.out.println("New side lenght 3 :");
					this.sideLenght3 = scanner.nextInt();
					break;
				}
				
				case 4:{
					System.out.println("New id :");
					this.id = scanner.nextInt();
					break;
				}
					
				case 5:{
					return;
				}
			}
		}
	}
	
}
