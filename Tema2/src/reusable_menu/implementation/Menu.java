package reusable_menu.implementation;

import java.util.ArrayList;
import java.util.Scanner;
import reusable_menu.abstractions.IMenuItem;

public class Menu implements IMenuItem{

	private ArrayList<IMenuItem> menuItems = new ArrayList<IMenuItem>();
    private boolean continueMenuLoop;
    private String text;
    private int shortCut;
    
    public Menu(String menuText, int shortCut, ArrayList<IMenuItem> menuItems)
    {
        text = menuText;
        this.shortCut = shortCut;
        
        this.menuItems.add(new MenuItem("Exit", 0, (parameters) -> {
            continueMenuLoop = false;
        }));
        
        this.menuItems.addAll(menuItems);
    }
    

    private void renderItems()
    {
        menuItems.forEach((item) -> {
            item.render();
        });
        
        System.out.println("Please enter your option ");
    }
    
    @Override
    public void execute()
    {
        continueMenuLoop = true;
        do
        {
           renderItems();
           int option = readUserOption();
           IMenuItem selectedItem = selectMenuItem(option);
           if (selectedItem != null)
           {
               selectedItem.execute();
           }            
            
        }while(continueMenuLoop);
    }    

    private int readUserOption() {
        
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        
        return option;        
    }

    private IMenuItem selectMenuItem(int option) 
    {
        
        for(int i = 0; i < menuItems.size(); i++)
        {
            if (menuItems.get(i).getShortCut() == option)
            {
                return menuItems.get(i);
            }
        }
        
        return null;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public int getShortCut() {
        return shortCut;
    }

    @Override
    public void render() {
        System.out.println(""+ shortCut + ". " + text);
    }
    
	
}
