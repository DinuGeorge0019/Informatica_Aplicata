package circle_plugin.implementation;

import pait_app_with_plugins.abstractions.IShape;
import pait_app_with_plugins.abstractions.IShapePlugin;

import java.awt.Point;
import java.util.Scanner;

public class CirclePlugin implements IShapePlugin {

    private Circle getNewCircle()
    {
        Scanner scanner = new Scanner(System.in);
        int radius;
        System.out.println("Radius :");
        radius = scanner.nextInt();
        System.out.println("Center : (x, y)");
        int x, y;
        x = scanner.nextInt();
        y = scanner.nextInt();
        Point centerPoint = new Point(x, y);


        return new Circle(radius, centerPoint);
    }


    @Override
    public IShape getShape() {
        return getNewCircle();
    }

    @Override
    public String getPluginName() {
        return "CirclePlugin";
    }
}
