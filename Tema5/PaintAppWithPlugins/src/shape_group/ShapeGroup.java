package shape_group;

import PaintMainApp.PaintApp;
import pait_app_with_plugins.abstractions.IShape;
import pait_app_with_plugins.abstractions.IShapePlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ShapeGroup extends IShape {
    private final String groupName;
    private final ArrayList<IShape> shapes;
    private final List<IShapePlugin> plugins;
    private final int idx;

    public ShapeGroup(String name, List<IShapePlugin> plugins)
    {
        this.groupName = name;
        this.shapes = new ArrayList<>();
        this.plugins = plugins;
        idx = index++;
    }

    private String readSubPaintName()
    {
        System.out.println("Paint name :");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private String readShapeName()
    {
        System.out.println("Shape name :");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void addSubPaint()
    {
        ShapeGroup subShapeGroup = new ShapeGroup(readSubPaintName(), plugins);
        PaintApp subApp = new PaintApp(subShapeGroup);
        subApp.load();
        subApp.execute();
        shapes.add(subShapeGroup);
    }

    private IShapePlugin getPlugin(String pluginName)
    {
        for(IShapePlugin plugin : plugins)
        {
            if(plugin.getPluginName().equals(pluginName))
                return plugin;
        }

        return null;
    }

    public void addShapeToPainting()
    {
        String shapeName = readShapeName();

        if(shapeName.equalsIgnoreCase( "circle"))
        {
            shapes.add(Objects.requireNonNull(getPlugin("CirclePlugin")).getShape());
        }
        else if(shapeName.equalsIgnoreCase("rectangle"))
        {
            shapes.add(Objects.requireNonNull(getPlugin("RectanglePlugin")).getShape());
        }
        else if(shapeName.equalsIgnoreCase("square"))
        {
            shapes.add(Objects.requireNonNull(getPlugin("SquarePlugin")).getShape());
        }
        else if(shapeName.equalsIgnoreCase("triangle"))
        {
            shapes.add(Objects.requireNonNull(getPlugin("TrianglePlugin")).getShape());
        }
    }

    private int readShapeIdx()
    {
        System.out.println("Shape idx :");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private IShape searchShapeAfterIdx()
    {
        int targetIdx = readShapeIdx();
        for (IShape shape : shapes) {
            if (targetIdx == shape.getShapeIdx()) {
                return shape;
            }
        }
        return null;
    }


    public void removeShapeFromPainting()
    {
        IShape shapeToRemove = searchShapeAfterIdx();
        if(shapeToRemove == null)
            return;
        shapes.remove(shapeToRemove);
    }

    @Override
    public void drawShape() {
        System.out.println("- - - - - - - - - - - - - - - -");
        System.out.println("Paint idx : " + idx );
        System.out.println("Paint name : " + groupName );
        for(IShape s : shapes)
        {
            s.drawShape();
        }
        System.out.println("- - - - - - - - - - - - - - - -");
    }

    @Override
    public int getShapeIdx() {
        return idx;
    }

    @Override
    public void modifyShape()
    {
        IShape shapeToModify = searchShapeAfterIdx();
        if(shapeToModify == null)
            return;
        shapeToModify.modifyShape();
    }



}
