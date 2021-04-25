package main;

import java.util.ArrayList;

import paint.sheet.Painting;
import reusable_menu.abstractions.IMenuItem;
import reusable_menu.implementation.Menu;
import reusable_menu.implementation.MenuItem;

public class PaintApp {
	
	private Menu mainMenu;
	Painting painting;
	
	public PaintApp(Painting painting) {
		this.painting = painting;
	}

	 public void load()
	    {	        
	        ArrayList<IMenuItem> menuItems = new ArrayList<IMenuItem>();
	        
	        int shortCut = 1;    
	        
	         
	       IMenuItem currentItem = new MenuItem("Add shape to painting", shortCut++, (parameters)->{
	    	   painting.addShapeToPainting();
	       });       
	       menuItems.add(currentItem);
	       
	       currentItem = new MenuItem("Remove shape form painting", shortCut++, (parameters)->{
	    	   painting.removeShapeFromPainting();
	       });       
	       menuItems.add(currentItem);    
	       
	       currentItem = new MenuItem("Draw paint", shortCut++, (parameters)->{
	    	   painting.draw();
	       });       
	       menuItems.add(currentItem); 
	       
	       currentItem = new MenuItem("Modify shape", shortCut++, (parameters)->{
	    	   painting.modifyShape();
	       });       
	       menuItems.add(currentItem); 
	       
	       currentItem = new MenuItem("Add subpainting", shortCut++, (parameters)->{
	    	   painting.addSubPaint();
	       });
	       menuItems.add(currentItem); 
	       
	        
	       mainMenu = new Menu("Main Menu", -1, menuItems);
	    }
	 
		public void execute()
		{
			mainMenu.execute();
		}
	
}
