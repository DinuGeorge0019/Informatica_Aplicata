package triangle_plugin.implementation;

import pait_app_with_plugins.abstractions.IShape;
import pait_app_with_plugins.abstractions.IShapePlugin;

import java.util.Scanner;

public class TrianglePlugin implements IShapePlugin {

    private Triangle getNewTriangle()
    {
        Scanner scanner = new Scanner(System.in);
        int sideLength1, sideLength2, sideLength3;
        System.out.println("Side lenght1 :");
        sideLength1 = scanner.nextInt();
        System.out.println("Side lenght2 :");
        sideLength2 = scanner.nextInt();
        System.out.println("Side lenght3 :");
        sideLength3 = scanner.nextInt();


        return new Triangle(sideLength1, sideLength2, sideLength3);
    }

    @Override
    public IShape getShape() {
        return getNewTriangle();
    }

    @Override
    public String getPluginName() {
        return "TrianglePlugin";
    }
}
