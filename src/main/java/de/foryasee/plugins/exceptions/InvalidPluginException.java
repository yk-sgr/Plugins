package de.foryasee.plugins.exceptions;

import java.io.File;
import java.io.IOException;

/**
 * Used for exceptions that are thrown while loading a plugin.
 */
public class InvalidPluginException extends IOException {

  public InvalidPluginException(final File file, final String message) {
    super(file.getAbsolutePath() + " " + message);
  }

  public InvalidPluginException(final File file, final Throwable cause) {
    super(file.getAbsolutePath() + " ", cause);
  }
}
