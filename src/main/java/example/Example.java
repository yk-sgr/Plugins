package example;

import de.foryasee.plugins.Plugin;
import de.foryasee.plugins.loader.PluginLoadedResult;
import de.foryasee.plugins.loader.impl.PluginLoader;
import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Example class for showing the usage of the {@link PluginLoader}.
 */
public class Example {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    // Create PluginLoader
    PluginLoader pluginLoader = new PluginLoader();

    // Store the CompletableFuture in a variable
    CompletableFuture<PluginLoadedResult<TestPlugin>> future = pluginLoader.load(new File("plugin.jar"));

    // Block till the future is completed (!!consider using the async way!!)
    PluginLoadedResult<TestPlugin> result = future.get();
    // Check if the loading succeeded, if not print the exception
    if (!result.succeeded()) {
      result.getThrowable().printStackTrace();
      return;
    }
    // Store the Plugin instance
    TestPlugin plugin = result.getPlugin();

    // Access your plugin methods, variables, ...
    plugin.test();
  }

  class TestPlugin implements Plugin {

    void test() {
      System.out.println("TEST");
    }
  }
}
