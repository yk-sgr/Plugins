package de.foryasee.plugins.loader;

import de.foryasee.plugins.Plugin;

/**
 * Represents the result of a loading action.
 *
 * @param <T> the type of the {@link Plugin} implementation.
 */
public class PluginLoadedResult<T extends Plugin> {

  private final T plugin;
  private final Throwable throwable;

  public PluginLoadedResult(final T plugin, final Throwable throwable) {
    this.plugin = plugin;
    this.throwable = throwable;
  }

  public T getPlugin() {
    return plugin;
  }

  public Throwable getThrowable() {
    return throwable;
  }

  public boolean succeeded() {
    return throwable == null;
  }
}
