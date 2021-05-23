package triangle_plugin.implementation;

import pait_app_with_plugins.abstractions.IShape;

import java.util.Scanner;

public class Triangle extends IShape {
    private int sideLength1;
    private int sideLength2;
    private int sideLength3;
    private final int idx;

    public Triangle(int sideLength1, int sideLength2, int sideLength3) {
        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
        this.sideLength3 = sideLength3;
        this.idx = index++;
    }


    @Override
    public void drawShape() {
        System.out.println("Shape idx: " + idx);
        System.out.println("Drawing Triangle, side lenght1 : " +
                + sideLength1 + " side lenght2 :" + sideLength2 +  " side lenght3 :" + sideLength3);
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
            System.out.println("1. Change side lenght 1");
            System.out.println("2. Change side lenght 2");
            System.out.println("3. Change side lenght 3");
            System.out.println("4. Exit");
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("New side lenght 1 :");
                    this.sideLength1 = scanner.nextInt();
                }
                case 2 -> {
                    System.out.println("New side lenght 2 :");
                    this.sideLength2 = scanner.nextInt();
                }
                case 3 -> {
                    System.out.println("New side lenght 3 :");
                    this.sideLength3 = scanner.nextInt();
                }
                case 4 -> {
                    return;
                }
            }
        }
    }
}
