# DiskLib
DiskLib is an easy-to-use zero dependency Disk Writer &amp; Disk Reader with built-in GZIP support for Java.

## 💡 Requirements
+ Java Runtime 1.8 **or higher**

## ⚙️ How To Add As Library
Add it as a maven dependency or just [download the latest release](https://github.com/Konloch/DiskLib/releases).
```xml
<dependency>
  <groupId>com.konloch</groupId>
  <artifactId>DiskLib</artifactId>
  <version>1.2.0</version>
</dependency>
```

## 👨‍💻 Links
* [Website](https://konloch.com/DiskLib/)
* [Discord Server](https://discord.gg/aexsYpfMEf)
* [Download Releases](https://github.com/Konloch/DiskLib/releases)

## 💻 How To Use
**You can pass *either* a String path or a File object for the first parameter. To use the GZIP functionality, use GZIPDiskReader or GZIPDiskWriter**

### For more examples
[View the test file here](https://github.com/Konloch/DiskLib/blob/main/src/test/java/com/konloch/DiskLibTest.java), it has examples of each function being used.


## ⬆️ Reading
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

## ⬇️ Writing
+ You can write / append `Lists`, or `Sets`, just pass where the string parameter goes for the content line.

### Write new file to disk / overwrite existing file
```java
DiskReader.write("hello.txt", "Hello ");
```

### Append to existing file
```java
DiskReader.append("hello.txt", "World");
```
