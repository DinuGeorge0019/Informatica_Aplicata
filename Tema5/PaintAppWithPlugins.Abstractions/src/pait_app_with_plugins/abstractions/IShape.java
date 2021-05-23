package pait_app_with_plugins.abstractions;

public abstract class IShape {
    protected static int index = 0;
    public abstract void drawShape();
    public abstract int getShapeIdx();
    public abstract void modifyShape();

}
