# Plugins
[![Build Status](https://travis-ci.com/ForYaSee/Plugins.svg?branch=master)](https://travis-ci.com/ForYaSee/Plugins)
[![Maintainability](https://api.codeclimate.com/v1/badges/696e6b68d04bc40e201c/maintainability)](https://codeclimate.com/github/ForYaSee/Plugins/maintainability)

This lightweight library provides a simple way to load external plugins into your application while running.
You are not bound to a specific use scenario and can use them for all.

+ **Requires JDK 11**

---

# Using Plugins
The .jar file you want to load must contain **exactly one** class that implements the `Plugin` interface.
An example how to actually load the Plugin exists in the `example` package.

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

## Contributors

[//]: contributors

<a href="https://github.com/DRSchlaubi"><img src="https://avatars0.githubusercontent.com/u/16060205?s=400&v=4" title="DRSchlaubi" width="80" height="80"></a>

[//]: contributors
