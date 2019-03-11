package de.foryasee.plugins.loader.impl;

import de.foryasee.plugins.Plugin;
import de.foryasee.plugins.exceptions.InvalidPluginException;
import de.foryasee.plugins.loader.IPluginLoader;
import de.foryasee.plugins.loader.PluginLoadedResult;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * Default {@link IPluginLoader} implementation.
 */
public class PluginLoader implements IPluginLoader {

  @Override
  public <T extends Plugin> CompletableFuture<PluginLoadedResult<T>> load(final File file) {
    Objects.requireNonNull(file);
    return CompletableFuture.supplyAsync(() -> {
      T plugin;
      try {
        checkFile(file);
        final var classLoader = getClassLoader(file);
        final var classes = getClassesFromJar(file, classLoader);
        final Class<T> clazz = getPluginClass(file, classes);
        plugin = clazz.getConstructor().newInstance();
      } catch (Exception e) {
        if (!(e instanceof InvalidPluginException)) {
          e = new InvalidPluginException(file, e);
        }
        return new PluginLoadedResult<>(null, e);
      }
      return new PluginLoadedResult<>(plugin, null);
    });
  }

  private ClassLoader getClassLoader(final File file) throws InvalidPluginException {
    try {
      return new URLClassLoader(new URL[] {file.toURI().toURL()});
    } catch (MalformedURLException e) {
      throw new InvalidPluginException(file, e);
    }
  }

  private Set<Class<?>> getClassesFromJar(final File file, final ClassLoader classLoader) throws InvalidPluginException {
    final var classes = new HashSet<Class<?>>();
    try (final var jarInputStream = new JarInputStream(new FileInputStream(file))) {
      JarEntry jarEntry;
      while ((jarEntry = jarInputStream.getNextJarEntry()) != null) {
        if (!jarEntry.getName().toLowerCase().endsWith(".class")) {
          continue;
        }
        classes.add(classLoader.loadClass(
            jarEntry.getName().substring(0, jarEntry.getName().length() - 6)
                .replace("/", "."))
        );
      }
    } catch (Exception e) {
      throw new InvalidPluginException(file, e);
    }
    return classes;
  }

  @SuppressWarnings("unchecked")
  private <T> Class<T> getPluginClass(final File file, final Set<Class<?>> classes) throws InvalidPluginException {
    final var pluginClasses = new ArrayList<Class<T>>();
    classes.forEach(clazz -> {
      if (!Plugin.class.isAssignableFrom(clazz) || Modifier.isAbstract(clazz.getModifiers())) {
        return;
      }
      try {
        pluginClasses.add((Class<T>) clazz);
      } catch (ClassCastException e) {
        // Instance check because we just have T
      }
    });
    if (pluginClasses.isEmpty()) {
      throw new InvalidPluginException(file, "contains no Plugin class.");
    } else if (pluginClasses.size() > 1) {
      throw new InvalidPluginException(file, "contains multiple Plugin classes: " + pluginClasses);
    }
    return pluginClasses.get(0);
  }

  private void checkFile(final File file) throws InvalidPluginException {
    if (!file.exists()) {
      throw new InvalidPluginException(file, "does not exist.");
    }
    if (!file.isFile()) {
      throw new InvalidPluginException(file, "is not a file.");
    }
    if (!file.getName().endsWith(".jar")) {
      throw new InvalidPluginException(file, "is not a .jar file.");
    }
  }
}
