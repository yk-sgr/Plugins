# Plugins
[![Build Status](https://travis-ci.com/ForYaSee/Plugins.svg?branch=master)](https://travis-ci.com/ForYaSee/Plugins)
[![Maintainability](https://api.codeclimate.com/v1/badges/696e6b68d04bc40e201c/maintainability)](https://codeclimate.com/github/ForYaSee/Plugins/maintainability)
[![](https://jitpack.io/v/ForYaSee/Plugins.svg)](https://jitpack.io/#ForYaSee/Plugins)

This lightweight library provides a simple way to load external Plugins into your application while running.

+ **Requires JDK 11**

---

# Using Plugins
The .jar file you want to load must contain **exactly one** class that implements the `Plugin` interface.
An example how to actually load the Plugin exists in the `example` package.

# Download

Gradle:
```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
...
dependencies {
  implementation 'com.github.ForYaSee:Plugins:Tag'
}
```

Maven:
```xml
<repositories>
  <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependency>
    <groupId>com.github.ForYaSee</groupId>
    <artifactId>Plugins</artifactId>
    <version>Tag</version>
</dependency>
```
