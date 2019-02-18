# Plugins
[![Build Status](https://travis-ci.com/ForYaSee/Plugins.svg?branch=master)](https://travis-ci.com/ForYaSee/Plugins)

This lightweight library provides a simple way to load external Plugins into your application while running.

+ **Requires JDK 11**

---

# Using Plugins
The .jar file you want to load must contain **exactly one** class that implements the `Plugin` interface.
An example how to actually load the Plugin exists in the `example` package.
