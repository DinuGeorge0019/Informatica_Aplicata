package PaintMainApp;

import pait_app_with_plugins.abstractions.IShapePlugin;
import plugins_manager.PluginsManager;
import shape_group.ShapeGroup;

import java.util.List;

public class PaintMainApp {

    public static void main(String[] args) {


        PluginsManager manager = new PluginsManager();
        try
        {
            manager.loadPlugins("/plugins");
        }
        catch(Exception e)
        {
            System.out.println("Modulele nu pot fi incarcate. " + e.getMessage());
        }


        List<IShapePlugin> plugins = manager.getPluginsList();
        if(!plugins.isEmpty())
        {
            PaintApp app = new PaintApp(new ShapeGroup("MainPainting", plugins));
            app.load();
            app.execute();
        }
        else
        {
            System.out.println("Nu exista module compatibile");
        }
    }


}
