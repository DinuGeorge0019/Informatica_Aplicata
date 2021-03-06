package reusable_menu.abstractions;

public interface IMenuItem {
    String getText();
    int getShortCut();
    void render();
    void execute();
}
