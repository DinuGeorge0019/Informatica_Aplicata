package paint.sheet;

import java.util.ArrayList;
import java.util.Scanner;

import reusable_menu.abstractions.IMenuItem;
import reusable_menu.implementation.Menu;
import reusable_menu.implementation.MenuItem;
import shape.abstractions.Shape;
import shape.implementation.Circle;
import shape.implementation.Point;
import shape.implementation.Rectangle;
import shape.implementation.Square;
import shape.implementation.Triangle;

public class Painting implements Shape{

	private Menu mainMenu;
	private String name;
	private ArrayList<Shape> shapes;

	public Painting(String name)
	{
		this.name = name;
		this.shapes = new ArrayList<Shape>();
	}
	
	@Override
	public int getIdx() {
		return 0;
	}
	
	private Circle getNewCircle()
	{
		Scanner scanner = new Scanner(System.in);
		int radius,  idx;
		System.out.println("Radius :");
		radius = scanner.nextInt();
		System.out.println("Center : (x, y)");
		int x, y;
		x = scanner.nextInt();
		y = scanner.nextInt();
		Point center = new Point(x, y);
		System.out.println("Index :");
		idx = scanner.nextInt();
		
		return new Circle(radius, center, idx);
	}
	
	private Triangle getNewTriangle()
	{
		Scanner scanner = new Scanner(System.in);
		int sideLenght;
		System.out.println("Side lenght :");
		sideLenght = scanner.nextInt();
		int x, y;
		System.out.println("Point1 : (x, y)");
		x = scanner.nextInt();
		y = scanner.nextInt();
		Point p1 = new Point(x, y);
		System.out.println("Point2 : (x, y)");
		x = scanner.nextInt();
		y = scanner.nextInt();
		Point p2 = new Point(x, y);
		System.out.println("Point3 : (x, y)");
		x = scanner.nextInt();
		y = scanner.nextInt();
		Point p3 = new Point(x, y);
		System.out.println("Index :");
		int idx = scanner.nextInt();
		
		return new Triangle(sideLenght, p1, p2, p3, idx);
	}
	
	private Rectangle getNewRectangle()
	{
		Scanner scanner = new Scanner(System.in);
		int width,  height, idx;
		System.out.println("Width :");
		width = scanner.nextInt();
		System.out.println("Height :");
		height = scanner.nextInt();
		System.out.println("Index :");
		idx = scanner.nextInt();
		
		return new Rectangle(width, height, idx);
	}
	
	private Square getNewSquare()
	{
		Scanner scanner = new Scanner(System.in);
		int sideLenght, idx;
		System.out.println("Side lenght :");
		sideLenght = scanner.nextInt();
		System.out.println("Index :");
		idx = scanner.nextInt();
		
		return new Square(sideLenght, idx);
	}
	
	int readShapeIdx()
	{
		System.out.println("Shape idx :");
		Scanner scanner = new Scanner(System.in);
		int idx = scanner.nextInt();
		return idx;
	}
	
	String readShapeName()
	{
		System.out.println("Shape name :");
		Scanner scanner = new Scanner(System.in);
		String shapeName = scanner.nextLine();
		return shapeName;
	}
	
	String readSubPaintName()
	{
		System.out.println("Paint name :");
		Scanner scanner = new Scanner(System.in);
		String paintName = scanner.nextLine();
		return paintName;
	}
	
	void addSubPaint()
	{
		Painting subPaint = new Painting(readSubPaintName());
		subPaint.load();
		subPaint.execute();
		
		shapes.add(subPaint);
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
	
	Shape sherchShapeAfterIdx()
	{
		int targetIdx = readShapeIdx();
		for(int i =0; i < shapes.size(); i++)
		{
			if(targetIdx == shapes.get(i).getIdx())
			{
				return shapes.get(i);
			}
		}
		return null;
	}
	
	
	public void removeShapeFromPainting()
	{
		Shape shapeToRemove = sherchShapeAfterIdx();
		if(shapeToRemove == null)
			return;		
		shapes.remove(shapeToRemove);
	}
	
	@Override
	public void draw() {
		System.out.println("Paint name : " + name );
		for(Shape s : shapes)
		{
			s.draw();
		}
	}
	
	void modifyShape()
	{
		removeShapeFromPainting();
		addShapeToPainting();
	}
	
	
	 public void load()
	    {
	        
	        ArrayList<IMenuItem> menuItems = new ArrayList<IMenuItem>();
	        ArrayList<IMenuItem> modifyShapesDataOptions = new ArrayList<IMenuItem>();
	        
	        int shortCut = 1;    
	        
	         
	       IMenuItem currentItem = new MenuItem("Add shape to painting", shortCut++, (parameters)->{
	    	   addShapeToPainting();
	       });       
	       menuItems.add(currentItem);
	       
	       currentItem = new MenuItem("Remove shape form painting", shortCut++, (parameters)->{
	    	   removeShapeFromPainting();
	       });       
	       menuItems.add(currentItem);    
	       
	       currentItem = new MenuItem("Draw paint", shortCut++, (parameters)->{
	    	   draw();
	       });       
	       menuItems.add(currentItem); 
	       
	       currentItem = new MenuItem("Modify shape", shortCut++, (parameters)->{
	    	   modifyShape();
	       });       
	       menuItems.add(currentItem); 
	       
	       currentItem = new MenuItem("Add subpainting", shortCut++, (parameters)->{
	    	   addSubPaint();
	       });       
	       menuItems.add(currentItem); 
	       
	        
	       mainMenu = new Menu("Main Menu", -1, menuItems);
	        
	    }
	 
		public void execute()
		{
			mainMenu.execute();
		}

}
