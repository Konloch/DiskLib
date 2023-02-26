# DiskLib
DiskLib is an easy-to-use zero dependency Disk Writer &amp; Disk Reader with built-in GZIP support for Java.

## How To Add As Library
Add it as a maven dependency or just [download the latest release](https://github.com/Konloch/DiskLib/releases).
```xml
<dependency>
  <groupId>com.konloch</groupId>
  <artifactId>DiskLib</artifactId>
  <version>1.1.0</version>
</dependency>
```

## Links
* [Website](https://konloch.com/DiskLib/)
* [Discord Server](https://discord.gg/aexsYpfMEf)
* [Download Releases](https://github.com/Konloch/DiskLib/releases)

## How To Use
**You can pass *either* a String path or a File object for the first parameter. To use the GZIP functionality, use GZIPDiskReader or GZIPDiskWriter**

### Write new file to disk / overwrite existing file
```java
DiskReader.write("hello.txt", "Hello ");
```

### Append to existing file
```java
DiskReader.append("hello.txt", "World");
```

### Reading Strings from disk
```java
ArrayList<String> lines = DiskReader.read("hello.txt");
```

### Reading String Arrays from disk
```java
String[] lines = DiskReader.readLines("hello.txt");
```

### Reading Bytes from disk
```java
byte[] bytes = DiskReader.readBytes("hello.txt");
```
