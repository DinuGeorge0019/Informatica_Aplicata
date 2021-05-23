package PaintMainApp;


import reusable_menu.implementation.*;
import reusable_menu.abstractions.*;
import shape_group.ShapeGroup;

import java.util.ArrayList;

public class PaintApp {

    private Menu mainMenu;
    private final ShapeGroup shapeGroup;

    public PaintApp(ShapeGroup painting) {
        this.shapeGroup = painting;
    }

    public void load()
    {
        ArrayList<IMenuItem> menuItems = new ArrayList<IMenuItem>();

        int shortCut = 1;


        IMenuItem currentItem = new MenuItem("Add shape to painting", shortCut++, (parameters)->{
            shapeGroup.addShapeToPainting();
        });
        menuItems.add(currentItem);

        currentItem = new MenuItem("Remove shape form painting", shortCut++, (parameters)->{
            shapeGroup.removeShapeFromPainting();
        });
        menuItems.add(currentItem);

        currentItem = new MenuItem("Draw paint", shortCut++, (parameters)->{
            shapeGroup.drawShape();
        });
        menuItems.add(currentItem);

        currentItem = new MenuItem("Modify shape", shortCut++, (parameters)->{
            shapeGroup.modifyShape();
        });
        menuItems.add(currentItem);

        currentItem = new MenuItem("Add subpainting", shortCut++, (parameters)->{
            shapeGroup.addSubPaint();
        });
        menuItems.add(currentItem);


        mainMenu = new Menu("Main Menu", -1, menuItems);
    }

    public void execute()
    {
        mainMenu.execute();
    }


}
