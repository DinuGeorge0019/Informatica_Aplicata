package circle_plugin.implementation;

import pait_app_with_plugins.abstractions.IShape;
import java.awt.Point;

import java.util.Scanner;


public class Circle extends IShape {

    private int radius;
    private final Point centerPoint;
    private final int idx;

    public Circle(int radius, Point centerPoint) {
        this.radius = radius;
        this.centerPoint = centerPoint;
        this.idx = index++;
    }


    @Override
    public void drawShape() {
        System.out.println("Shape idx: " + idx);
        System.out.println("Drawing circle : ");
        System.out.println("Center : (" + centerPoint.x + "," + centerPoint.y+ ")");
        System.out.println("Radius : " + radius);
    }

    @Override
    public int getShapeIdx() {
        return this.idx;
    }

    @Override
    public void modifyShape()
    {
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            System.out.println("Choose option :");
            System.out.println("1. Change center point");
            System.out.println("2. Change radius");
            System.out.println("3. Exit");
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("Center : (x, y)");
                    this.centerPoint.x = scanner.nextInt();
                    this.centerPoint.y = scanner.nextInt();
                }
                case 2 -> {
                    System.out.println("New radius :");
                    this.radius = scanner.nextInt();
                }
                case 3 -> {
                    return;
                }
            }
        }
    }



}
