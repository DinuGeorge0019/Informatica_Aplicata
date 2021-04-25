package paint.sheet;

import java.util.ArrayList;
import java.util.Scanner;

import main.PaintApp;
import shape.abstractions.Shape;
import shape.implementation.Circle;
import shape.implementation.Point;
import shape.implementation.Rectangle;
import shape.implementation.Square;
import shape.implementation.Triangle;

public class Painting implements Shape{

	private String name;
	private ArrayList<Shape> shapes;

	public Painting(String name)
	{
		this.name = name;
		this.shapes = new ArrayList<Shape>();
	}
	
	@Override
	public int getId() {
		return 0;
	}
	
	@SuppressWarnings("resource")
	private Circle getNewCircle()
	{
		Scanner scanner = new Scanner(System.in);
		int radius,  id;
		System.out.println("Radius :");
		radius = scanner.nextInt();
		System.out.println("Center : (x, y)");
		int x, y;
		x = scanner.nextInt();
		y = scanner.nextInt();
		Point centerPoint = new Point(x, y);
		System.out.println("Shape id :");
		id = scanner.nextInt();
		
		return new Circle(radius, centerPoint, id);
	}
	
	@SuppressWarnings("resource")
	private Triangle getNewTriangle()
	{
		Scanner scanner = new Scanner(System.in);
		int sideLenght1, sideLenght2, sideLenght3;
		System.out.println("Side lenght1 :");
		sideLenght1 = scanner.nextInt();
		System.out.println("Side lenght2 :");
		sideLenght2 = scanner.nextInt();
		System.out.println("Side lenght3 :");
		sideLenght3 = scanner.nextInt();
		System.out.println("Shape id :");
		int id = scanner.nextInt();
		
		return new Triangle(sideLenght1, sideLenght2, sideLenght3, id);
	}
	
	@SuppressWarnings("resource")
	private Rectangle getNewRectangle()
	{
		Scanner scanner = new Scanner(System.in);
		int width,  height, id;
		System.out.println("Width :");
		width = scanner.nextInt();
		System.out.println("Height :");
		height = scanner.nextInt();
		System.out.println("Shape id :");
		id = scanner.nextInt();
		
		return new Rectangle(width, height, id);
	}
	
	
	@SuppressWarnings("resource")
	private Square getNewSquare()
	{
		Scanner scanner = new Scanner(System.in);
		int sideLenght, id;
		System.out.println("Side lenght :");
		sideLenght = scanner.nextInt();
		System.out.println("Shape id :");
		id = scanner.nextInt();
		
		return new Square(sideLenght, id);
	}
	
	@SuppressWarnings("resource")
	int readShapeId()
	{
		System.out.println("Shape id :");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		return id;
	}
	
	@SuppressWarnings("resource")
	String readShapeName()
	{
		System.out.println("Shape name :");
		Scanner scanner = new Scanner(System.in);
		String shapeName = scanner.nextLine();
		return shapeName;
	}
	
	@SuppressWarnings("resource")
	String readSubPaintName()
	{
		System.out.println("Paint name :");
		Scanner scanner = new Scanner(System.in);
		String paintName = scanner.nextLine();
		return paintName;
	}
	
	public void addSubPaint()
	{
		Painting subPainting = new Painting(readSubPaintName());
		PaintApp subApp = new PaintApp(subPainting);
		subApp.load();
		subApp.execute();
		shapes.add(subPainting);
	}
	
	public void addShapeToPainting()
	{
		String shapeName = readShapeName();
		if(shapeName.equalsIgnoreCase("circle"))
		{
			shapes.add(getNewCircle());
		}
		else if(shapeName.equalsIgnoreCase("rectangle"))
		{
			shapes.add(getNewRectangle());
		}else if(shapeName.equalsIgnoreCase("square"))
		{
			shapes.add(getNewSquare());
		}else if(shapeName.equalsIgnoreCase("triangle"))
		{
			shapes.add(getNewTriangle());
		}
	}
	
	Shape sherchShapeAfterId()
	{
		int targetIdx = readShapeId();
		for(int i =0; i < shapes.size(); i++)
		{
			if(targetIdx == shapes.get(i).getId())
			{
				return shapes.get(i);
			}
		}
		return null;
	}
	
	
	public void removeShapeFromPainting()
	{
		Shape shapeToRemove = sherchShapeAfterId();
		if(shapeToRemove == null)
			return;		
		shapes.remove(shapeToRemove);
	}
	
	@Override
	public void draw() {
		System.out.println("- - - - - - - - - - - - - - - -");
		System.out.println("Paint name : " + name );
		for(Shape s : shapes)
		{
			s.draw();
		}
		System.out.println("- - - - - - - - - - - - - - - -");
	}
	
	@Override
	public void modifyShape()
	{
		Shape shapeToModify = sherchShapeAfterId();
		if(shapeToModify == null)
			return;		
		shapeToModify.modifyShape();
	}
	
	

}
