# FastStringUtils
FastStringUtils is an easy-to-use zero dependency collection of very fast String utility functions for Java.

## How To Add As Library
Add it as a maven dependency or just [download the latest release](https://github.com/Konloch/FastStringUtils/releases).
```xml
<dependency>
  <groupId>com.konloch</groupId>
  <artifactId>FastStringUtils</artifactId>
  <version>1.2.0</version>
</dependency>
```

## Links
* [Website](https://konloch.com/FastStringUtils/)
* [Discord Server](https://discord.gg/aexsYpfMEf)
* [Download Releases](https://konloch.com/FastStringUtils/releases)

## How To Use
This is a very small library and only contains a handful of functions.

### Splitting a String with a supplied separator.
By default, the Java String.split function is regex based, as a general rule, I avoid using it in all of my projects. Instead, I opt for using this library to replace that function.

```java
//split the string using the space character as a separator
String[] simpleSplitExample = FastStringUtils.split("Split Example", " ");

//split the string using the space character as a separator, with a maximum search limit of 2
String[] limiterSplitExample = FastStringUtils.split("Split Example With A Limit ", " ", 2);

//split the string using the space character as a separator, with a maximum search limit of 2, and preserve the separator
String[] limiterSplitExamplePreseveSeparator = FastStringUtils.split("Split Example With A Limit ", " ", 2, true);
```

### Check the value of a String
These functions are used to do fast non-strict checks to see if the string can represent specific types.

```java
boolean isNull = FastStringUtils.isNull("null");
boolean isBoolean = FastStringUtils.isBoolean("false");
boolean isInteger = FastStringUtils.isInteger("1");
boolean isDouble = FastStringUtils.isDouble("1.0D");
boolean isFloat = FastStringUtils.isFloat("1.0F");
```
