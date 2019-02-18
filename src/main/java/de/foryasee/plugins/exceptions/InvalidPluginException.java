package de.foryasee.plugins.exceptions;

import java.io.File;
import java.io.IOException;

/**
 * Used for exceptions that are thrown while loading a plugin.
 */
public class InvalidPluginException extends IOException {

  public InvalidPluginException(File file, String message) {
    super(file.getAbsolutePath() + " " + message);
  }

  public InvalidPluginException(File file, String message, Throwable cause) {
    super(file.getAbsolutePath() + " " + message, cause);
  }

  public InvalidPluginException(File file, Throwable cause) {
    super(file.getAbsolutePath() + " ", cause);
  }
}
