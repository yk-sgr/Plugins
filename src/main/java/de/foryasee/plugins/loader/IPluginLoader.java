package de.foryasee.plugins.loader;

import de.foryasee.plugins.Plugin;
import java.io.File;
import java.util.concurrent.CompletableFuture;

/**
 * Handles the loading of {@link Plugin}s.
 */
public interface IPluginLoader {

  /**
   * Loads a plugin from a file.
   *
   * @param file the <strong>.jar</strong> that includes the {@link Plugin} implementation.
   * @param <T> the type of the {@link Plugin} implementation.
   * @return a {@link CompletableFuture}.
   */
  <T extends Plugin> CompletableFuture<PluginLoadedResult<T>> load(File file);

  /**
   * @see #load(File)
   * @param file the location of the file.
   */
  default <T extends Plugin> CompletableFuture<PluginLoadedResult<T>> load(String file) {
    return load(new File(file));
  }
}
