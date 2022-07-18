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