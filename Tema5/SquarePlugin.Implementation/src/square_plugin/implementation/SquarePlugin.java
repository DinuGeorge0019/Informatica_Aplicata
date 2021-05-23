package square_plugin.implementation;

import pait_app_with_plugins.abstractions.IShape;
import pait_app_with_plugins.abstractions.IShapePlugin;

import java.util.Scanner;

public class SquarePlugin implements IShapePlugin {

    private Square getNewSquare()
    {
        Scanner scanner = new Scanner(System.in);
        int sideLength;
        System.out.println("Side length :");
        sideLength = scanner.nextInt();

        return new Square(sideLength);
    }

    @Override
    public IShape getShape() {
        return getNewSquare();
    }

    @Override
    public String getPluginName() {
        return "SquarePlugin";
    }
}
