package reusable_menu.implementation;

import java.util.ArrayList;
import java.util.Scanner;
import reusable_menu.abstractions.IMenuItem;

public class Menu implements IMenuItem{

    private final ArrayList<IMenuItem> menuItems = new ArrayList<IMenuItem>();
    private boolean continueMenuLoop;
    private final String text;
    private final int shortCut;

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
        menuItems.forEach(IMenuItem::render);

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

        return scanner.nextInt();
    }

    private IMenuItem selectMenuItem(int option)
    {

        for (IMenuItem menuItem : menuItems) {
            if (menuItem.getShortCut() == option) {
                return menuItem;
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
