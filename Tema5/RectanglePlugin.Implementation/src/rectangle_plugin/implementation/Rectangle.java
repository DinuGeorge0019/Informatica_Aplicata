package rectangle_plugin.implementation;

import pait_app_with_plugins.abstractions.IShape;

import java.util.Scanner;

public class Rectangle extends IShape {
    private int width;
    private int height;
    private final int idx;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
        this.idx = index++;
    }

    @Override
    public void drawShape() {
        System.out.println("Shape idx: " + idx);
        System.out.println("Drawing Rectangle, width : " + width + ", height : " + height);
    }

    @Override
    public int getShapeIdx() {
        return idx;
    }

    @Override
    public void modifyShape()
    {
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            System.out.println("Choose option :");
            System.out.println("1. Change width");
            System.out.println("2. Change height");
            System.out.println("3. Exit");
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("New width :");
                    this.width = scanner.nextInt();
                }
                case 2 -> {
                    System.out.println("New height :");
                    this.height = scanner.nextInt();
                }
                case 3 -> {
                    return;
                }
            }
        }
    }
}
