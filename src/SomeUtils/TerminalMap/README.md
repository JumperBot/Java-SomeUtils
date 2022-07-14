# SomeUtils/TerminalMap

```java
package SomeUtils.TerminalMap;
```

---

## TerminalMap.java

```java
import SomeUtils.TerminalMap.TerminalMap;
```
---

### Public Variables

---

```java
public static final char fullBlock; //█
public static final char midFullBlock; //▆
public static final char empty; //░
public static final char occupied; //▓
```

These variables are placeholders for different types of blocks.

---

### Public Methods

---

```java
public TerminalMap();
public TerminalMap(final int width, final int height);
public TerminalMap(final char[][] newMap); //throws Exception
```

Initialize either by setting the map's width and height...

...Or by dangerously creating a map yourself...

...Or by letting the class create a 3x3 map itself.

---

```java
public void setMap(final char[][] newMap); //throws Exception
```

Manually setting the map yourself. 

---

```java
public void set(final int x, final int y, final char in);
```

Set the x and y coordinates of the map into the specified char.

---

```java
public char get(final int x, final int y){
```

Get the character in the map by the specified x and y coordinates.

---

```java
//Row = horizontal
public char[] getRow(final int y);
//Column = vertical
public char[] getColumn(final int x);
```

Get the specified row or column.

---

```java
public char[][] getMap();
```

Get the internal map.

---

```java
public void printMap();
public void printMap(final boolean useBorders);
public void printMap(final boolean useBorders, final boolean useThinnerBorders);
```

Print the map with three different options...

...Print the map with the default configuration...

...Print the map with borders...

...Or print the map with thinner borders.

---