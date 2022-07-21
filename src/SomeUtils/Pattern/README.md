# SomeUtils/Pattern

```java
package SomeUtils.Pattern;
```

---

## PatternFinder.java

```java
import SomeUtils.Pattern.PatternFinder;
```
---

### Public Methods

---

```java
public PatternFinder(final String in);
```

Initialize the PatternFinder by giving it a String to find patterns in.

---

```java
public PatternFinder findAll(final int size);
```

Find all patterns of a specific length/size.

---

```java
public PatternFinder removeOnes();
```

Remove all patterns that only occur once in the input String.

---

```java
public String getInput();
```

Get the input String passed into the constructor.

---

```java
public String[][] toArray();
public String[][] getArray();
```

Get the internal array to be used later on.

---

## PatternMaker.java

```java
import SomeUtils.Pattern.PatternMaker;
```

---

### Public Variables

---

```java
/**From Pattern.java
  *Go to their website for more details:
  *https://hg.openjdk.java.net/jdk8u/jdk8u/jdk/file/tip...
  *.../src/share/classes/java/util/regex/Pattern.java
  **/
public static final int UNIX_LINES=0x01;
public static final int CASE_INSENSITIVE=0x02;
public static final int COMMENTS=0x04;
public static final int MULTILINE=0x08;
public static final int LITERAL=0x10;
public static final int DOTALL=0x20;
public static final int CANON_EQ=0x80;
public static final int UNICODE_CHARACTER_CLASS=0x100;
```

These are the flags to be passed to the #compile() method.

---

### Public Methods

---

```java
public PatternMaker();
public PatternMaker(final String in);
public PatternMaker(final Pattern in);
```

Create an instance either by...

...Passing nothing...

...Passing an initial String regex...

...Or by passing an already compiled Pattern/regex.

---

```java
public PatternMaker add(final String in);
```

Pass a specified/custom String into the internal StringBuilder.

---

```java
public PatternMaker anyOf(final String in);
public PatternMaker notAnyOf(final String in);
```

Match any of or anything that is not any of the char(s).

---

```java
public PatternMaker rangeOf(final char in, final char in2)
```

Find a character in a certain range.

Should be used either with #anyOf() or #notAnyOf.

---

```java
public PatternMaker or(final String in);
```

Adds an or statement.

Should be used either with #anyOf() or #notAnyOf.

---

```java
public PatternMaker any();
```

Match any char.

---

```java
public PatternMaker beginsWith(final String in);
public PatternMaker endsWith(final String in);
```

Check for a match in the beginning or end of a String.

---

```java
public PatternMaker anyNumber();
```

Match for any number/digit, from 0 to 9.

---

```java
public PatternMaker whitespace();
```

Match for any kind of whitespace.

---

```java
public PatternMaker wordBoundary();
```

Match for a pattern before or after a word boundary.

---

```java
public PatternMaker unicode(final String in);
```

Match for a certain unicode character.

---

```java
public PatternMaker once();
public PatternMaker noneOrMore();
public PatternMaker onceOrNone();
public PatternMaker atleastOnce();
public PatternMaker occurOnly(final int in);
public PatternMaker atleast(final int in);
public PatternMaker atleastRange(final int from, final int to);
```

Match only for a certain amount of times.

---

```java
public PatternMaker captureRecent();
```

Capture the recent pattern.

In other words, remember the match.

---

```java
public Pattern compile();
public Pattern compile(final int in);
```

Compile the Pattern either with or without a flag.

---

```java
@Override
public String toString();
```

Get the Pattern as a String.

---