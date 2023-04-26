# units4j

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.echocat.units4j/units4j/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.echocat.units4j/units4j)

Sets of units to use within Java.

## Topics

* [Getting started](#getting-started)
* [Contributing](#contributing)
* [License](#license)

## Getting started

### Dependency

#### 1. Register our repository (optional)

You can directly register our repository if you want always the latest version. The central can be versions behind.

##### Maven

```xml
<repositories>
    <repository>
        <id>central</id>
        <url>https://repo.maven.apache.org/maven2</url>
    </repository>
    <repository>
        <id>echocat</id>
        <url>https://packages.echocat.org/maven</url>
    </repository>
</repositories>
```

##### Gradle

```groovy
repositories {
    mavenCentral()
    maven {
        url "https://packages.echocat.org/maven"
    }
}
```

#### 2. Pick your version


[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.echocat.units4j/units4j/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.echocat.units4j/units4j)

Find your desired version you want to install (usually the latest one) [by looking it up in our repository](https://github.com/echocat/units4j/packages/) or directly at [the Maven Central](http://search.maven.org/#search|ga|1|g:org.echocat.units4j%20AND%20a:units4j).

#### 3. Add the dependency

##### Maven

```xml 
<dependency>
    <groupId>org.echocat.units4j</groupId>
    <artifactId>units4j</artifactId>
    <version><!-- THE VERSION --></version>
</dependency>
```

##### Gradle

```groovy
compile 'org.echocat.units4j:units4j:<THE VERSION>'
```


## Contributing

units4j is an open source project of [echocat](https://echocat.org). So if you want to make this project even better, you can
contribute to this project on [GitHub](https://github.com/echocat/units4j) by
[fork us](https://github.com/echocat/units4j/fork).

If you commit code to this project you have to accept that this code will be released under the [license](#license) of this project.

## License

See [LICENSE](LICENSE) file.
