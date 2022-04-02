# SimplexCL
 
This is an abstracted command system designed to make Paper's default command loading and building cleaner and prettier. There are numerous things you can do, and a Javadoc will be provided soon. Everything inside the plugin is docced and you can find doccing in the source as well.

To use this in your plugin, simply add the following to your build.gradle:

```Groovy
plugins {
  id "com.github.johnrengelman.shadow" version "7.1.2"
}

repositories {
    maven {
        name = 'sonatype'
        url = 'https://s01.oss.sonatype.org/content/groups/public/'
    }
}

dependencies {
    shadow 'io.github.simplexdevelopment:SimplexCL:1.0.0'
}
```
