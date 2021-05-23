package square_plugin.implementation;

import pait_app_with_plugins.abstractions.IShape;

import java.util.Scanner;

public class Square extends IShape {

    private int sideLength;
    private final int idx;


    public Square(int sideLength) {
        this.sideLength = sideLength;
        this.idx = index++;
    }

    @Override
    public void drawShape() {
        System.out.println("Shape idx: " + idx);
        System.out.println("Drawing Square, side lenght : " + sideLength);
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
            System.out.println("1. Change side length");
            System.out.println("2. Exit");
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("New side length :");
                    this.sideLength = scanner.nextInt();
                }
                case 2 -> {
                    return;
                }
            }
        }
    }



}
