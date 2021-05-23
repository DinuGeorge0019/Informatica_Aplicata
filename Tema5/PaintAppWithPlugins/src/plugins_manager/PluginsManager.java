package plugins_manager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import pait_app_with_plugins.abstractions.*;

public class PluginsManager {
    private final List<IShapePlugin> pluginsList = new ArrayList<>();

    private IShapePlugin loadPlugin(File jarFile)
    {
        IShapePlugin retPlugin = null;
        try
        {
            System.out.println("Looking for plugins in: " + jarFile.getAbsolutePath());
            URI jarURI = jarFile.toURI();
            ClassLoader loader = URLClassLoader.newInstance(new URL[]{jarURI.toURL()}, getClass().getClassLoader());
            List<String> classesInJar = getJARClasses(jarFile.getAbsolutePath());
            for(String currentClassName : classesInJar)
            {
                System.out.println("Checking class: " + currentClassName);
                Class<?> currentClass = Class.forName(currentClassName, true, loader);
                //if the class implements our plugin interface
                if (IShapePlugin.class.isAssignableFrom(currentClass))
                {
                    System.out.println("Seems like class " + currentClassName + " is a plugin");
                    //we create an instance for the plugin
                    retPlugin = (IShapePlugin)currentClass.getConstructor().newInstance();
                    break;
                }
            }

        }
        catch(Exception  e)
        {
            retPlugin = null;
            System.out.println("Failed to load plugin from: " + jarFile.getAbsolutePath() + "; " + e.getMessage());
        }

        return retPlugin;
    }

    private List<String> getJARClasses(String jarPath) throws IOException
    {
        List<String> classNames = new ArrayList<>();
        ZipInputStream zip = new ZipInputStream(new FileInputStream(jarPath));
        for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry())
        {
            if (!entry.isDirectory() && entry.getName().endsWith(".class"))
            {
                String className = entry.getName().replace('/', '.'); // including ".class"
                classNames.add(className.substring(0, className.length() - ".class".length()));
            }
        }

        return classNames;
    }

    public void loadPlugins(String directory)
    {
        File pluginsDir = new File(System.getProperty("user.dir") + directory);
        FilenameFilter fileFilter = (dir, name) -> name.endsWith(".jar");


        for (File jar : Objects.requireNonNull(pluginsDir.listFiles(fileFilter)))
        {
            IShapePlugin plugin = loadPlugin(jar);
            if (plugin != null)
            {
                pluginsList.add(plugin);
            }
        }
    }

    public List<IShapePlugin> getPluginsList()
    {
        return pluginsList;
    }
}
