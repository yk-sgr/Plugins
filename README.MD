# Plugins
[![Build Status](https://travis-ci.com/ForYaSee/Plugins.svg?branch=master)](https://travis-ci.com/ForYaSee/Plugins)
[![Maintainability](https://api.codeclimate.com/v1/badges/696e6b68d04bc40e201c/maintainability)](https://codeclimate.com/github/ForYaSee/Plugins/maintainability)

This lightweight library provides a simple way to load external plugins into your application while running.
You are not bound to a specific use scenario and can use them for all.

+ **Requires JDK 11**

---

# Using Plugins
The .jar file you want to load must contain **exactly one** class that implements the `Plugin` interface.
An de.foryasee.plugins.example how to actually load the Plugin exists in the `de.foryasee.plugins.example` package.

# Download

Gradle:
```gradle
dependencies {
  implementation 'de.foryasee:plugins:version'
}
```

Maven:
```xml
<dependency>
  <groupId>de.foryasee</groupId>
  <artifactId>plugins</artifactId>
  <version>VERSION</version>
</dependency>
```
