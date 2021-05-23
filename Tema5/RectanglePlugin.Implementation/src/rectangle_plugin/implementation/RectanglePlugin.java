package rectangle_plugin.implementation;

import pait_app_with_plugins.abstractions.IShape;
import pait_app_with_plugins.abstractions.IShapePlugin;

import java.util.Scanner;

public class RectanglePlugin implements IShapePlugin {

    @SuppressWarnings("resource")
    private Rectangle getNewRectangle()
    {
        Scanner scanner = new Scanner(System.in);
        int width,  height, id;
        System.out.println("Width :");
        width = scanner.nextInt();
        System.out.println("Height :");
        height = scanner.nextInt();

        return new Rectangle(width, height);
    }

    @Override
    public IShape getShape() {
        return getNewRectangle();
    }

    @Override
    public String getPluginName() {
        return "RectanglePlugin";
    }
}
